package org.example.user;

import java.util.HashMap;
import java.util.Map;

public class InMemoryUserDao implements UserDao{


    private final Map<String, User> users;

    public InMemoryUserDao() {
        users = new HashMap<>();
        users.put("John", new User("John", "qwerty"));
        users.put("Test", new User("Test","qwerty"));
    }

    @Override
    public User save(User user) {
        return users.put(user.getName(), user);
    }

    @Override
    public User findByName(String name) {
        return users.get(name);
    }

    @Override
    public User delete(String name) {
       return users.remove(name);
    }

    @Override
    public User changeUser(String name,User user) {
        return users.put(name,user);
    }

}
