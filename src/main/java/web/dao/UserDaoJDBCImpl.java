package web.dao;

import web.util.Util;
import web.model.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserDaoJDBCImpl implements UserDao {

    private int usersCount = 0;

    private final Connection connection = Util.getConnection();

    public UserDaoJDBCImpl() {

    }


    public void saveUser(String name, String lastName, byte age) {
        String query = "INSERT INTO Users ("
                + " id,"
                + " name,"
                + " lastName,"
                + " age ) VALUES ("
                + "?, ?, ?, ?)";

        try (PreparedStatement st = connection.prepareStatement(query)) {
            st.setInt(1, ++usersCount);
            st.setString(2, name);
            st.setString(3, lastName);
            st.setByte(4, age);

            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        try (Statement statement = connection.createStatement()) {
            String sql = "DELETE FROM Users " +
                    "WHERE id =" + id;
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public User getUserById(long id) {
        String sql = "SELECT * FROM Users WHERE id =" + id;

        try (
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery(sql)
        ) {
            while (rs.next()) {
                User user = new User(
                        rs.getString("name"),
                        rs.getString("lastName"),
                        rs.getByte("age")
                );

                user.setId(rs.getLong("id"));
                return user;
            }
            return null;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM Users";

        try (
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery(sql)
        ) {
            while (rs.next()) {
                User user = new User(
                        rs.getString("name"),
                        rs.getString("lastName"),
                        rs.getByte("age")
                );

                user.setId(rs.getLong("id"));
                users.add(user);
            }
            return users;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    public void createUsersTable() {
        String sql = "CREATE TABLE IF NOT EXISTS Users " +
                "(id INTEGER not NULL, " +
                " name VARCHAR(255), " +
                " lastName VARCHAR(255), " +
                " age INTEGER, " +
                " PRIMARY KEY ( id ))";

        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void dropUsersTable() {
        String sql = "DROP TABLE IF EXISTS Users";

        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void cleanUsersTable() {
        String sql = "SELECT * FROM Users";
        try (
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery(sql)
        ) {
            while (rs.next()) {
                int id = rs.getInt("id");
                removeUserById(id);

                System.out.println("User c id " + id + " and name "
                        + rs.getString("name") + " "
                        + rs.getString("lastName") +
                        " was delete");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
