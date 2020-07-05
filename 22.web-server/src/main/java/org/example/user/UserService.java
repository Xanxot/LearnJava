package org.example.user;

import java.util.Optional;

public class UserService {

    private final org.example.user.UserDao userDao;

    public UserService(org.example.user.UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean authenticate(String name, String password) {
        return Optional.ofNullable(userDao.findByName(name))
                .map(user -> user.getPassword().equals(password))
                .orElse(false);
    }

}
