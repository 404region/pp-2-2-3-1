package web.dao;
import web.model.User;

import java.util.List;

public interface UserDao {
    void createUsersTable();

    void dropUsersTable();

    void saveUser(String name, String lastName, byte age);

    User getUserById(long id);

    void removeUserById(long id);

    List<User> getAllUsers();

    void cleanUsersTable();
}