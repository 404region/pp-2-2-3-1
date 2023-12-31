package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    void saveUser(User user);
    void updateUser(User user);

    void deleteById(Long id);

    User findById(Long id);
}
