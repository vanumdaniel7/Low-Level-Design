package lld.patterns.repository;

import java.util.List;

public interface UserRepository {
    void addUser(String username, String email);
    User findUser(Integer id);
    List<User> getAllUsers();
}
