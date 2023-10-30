package web.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import web.dao.UserDaoHibernateImpl;
import web.model.User;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserDaoHibernateImpl userDao = new UserDaoHibernateImpl();

    private final List<User> users = userDao.getAllUsers();
    /*private final List<User> users = Arrays.asList(
            new User("Mary", "L", (byte) 20),
            new User("Holly", "K", (byte) 22),
            new User("Ann", "J", (byte) 21)
    );*/

    @Override
    public List<User> getAllUsers(int count) {
        if (count < 1 || count > users.size()) {
            count = users.size();
        }
        return users.subList(0, count);
    }


    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }
}
