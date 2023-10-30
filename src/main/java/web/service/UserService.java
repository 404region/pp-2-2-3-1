package web.service;
import web.model.User;
import java.util.List;

public interface UserService {
    List<User> getAllUsers(int count);

    void saveUser(User user);
}
