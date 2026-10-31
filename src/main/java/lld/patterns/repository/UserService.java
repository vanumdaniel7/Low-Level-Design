package lld.patterns.repository;

import java.util.List;

public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void registerUser(String username, String email) {
        this.userRepository.addUser(username, email);
    }

    public User findUser(Integer id) {
        return this.userRepository.findUser(id);
    }

    public List<User> getAllUsers() {
        return this.userRepository.getAllUsers();
    }
}
