package web.dao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import web.model.User;

import java.util.List;

public interface UserDao {
    void saveUser(User user);

    User getUserById(long id);

    void removeUserById(long id);

    List<User> getAllUsers();
}
