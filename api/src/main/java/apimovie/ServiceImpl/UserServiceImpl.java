package apimovie.ServiceImpl;

import apimovie.Model.User;
import apimovie.IService.UserService;
import apimovie.Repository.UserRepository;
//import apimovie.Config.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/*@Service
public class UserServiceImpl implements UserService, UserDetailsService {*/

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(String id) {
        return userRepository.findById(id);
    }

    @Override
    public User createUser(User user) {
        user.setId(UUID.randomUUID().toString());
        return userRepository.save(user);
    }

    @Override
    public User updateUser(String id, User user) {
        user.setId(id);
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }

    /*@Override
    public Optional<User> loginUser(String email, String password) {

        Optional<User> userOptional = userRepository.findByEmail(email);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (checkPassword(password, user.getPassword())) {
                JwtTokenProvider jwtTokenProvider = new JwtTokenProvider();
                String token = jwtTokenProvider.generateToken(user.getEmail());
                user.setToken(token); // Definir o token no objeto User (se tiver um campo para isso)
                return Optional.of(user);

            }
        }
        return Optional.empty();
    }*/

    /*@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username)
            .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + username));
        return user;
    }
    private String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    private boolean checkPassword(String plainPassword, String hashedPassword) {
        return BCrypt.checkpw(plainPassword, hashedPassword);
    }*/
    
}

