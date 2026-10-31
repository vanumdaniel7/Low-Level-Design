package lld.patterns.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryUserRepository implements UserRepository {

    private Map<Integer, User> userMap;
    private int nextId;

    public InMemoryUserRepository() {
        this.userMap = new HashMap<>();
        this.nextId = 1;
    }

    @Override
    public void addUser(String username, String email) {
        userMap.put(nextId++, new User(username, email));
    }

    @Override
    public User findUser(Integer id) {
        return userMap.get(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userMap.values().stream().toList();
    }
}
