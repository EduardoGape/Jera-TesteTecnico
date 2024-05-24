package br.com.themoviedb.api.Iservice;


import java.util.List;
import br.com.themoviedb.api.model.User;
import java.util.Optional;

public interface IUserService {
    List<User> getAllUsers();
    Optional<User> getUserById(String id);
    User createUser(User user);
    User updateUser(String id, User user);
    void deleteUser(String id);
    String loginUser(String email, String password);
}

