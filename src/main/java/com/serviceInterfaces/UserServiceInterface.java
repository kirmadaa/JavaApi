package com.serviceInterfaces;

import com.model.User;

public interface UserServiceInterface {
        public User saveUser(User user);
        public Iterable<User> getAllUsers();
        public User getUserById(int id);
        public void deleteUser(int id);
        public void updateUser(User user, int id);
    }
