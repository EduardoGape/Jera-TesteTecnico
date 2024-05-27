package apimovie.IService;

import java.util.List;
import java.util.Optional;

import apimovie.Model.User;

public interface UserService {
    List<User> getAllUsers();
    Optional<User> getUserById(String id);
    User createUser(User user);
    User updateUser(String id, User user);
    void deleteUser(String id);
    Optional<User> loginUser(String email, String password);
}
