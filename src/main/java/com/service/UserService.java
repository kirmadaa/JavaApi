package com.service;

import com.model.User;
import com.repository.UserRepository;
import com.serviceInterfaces.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserServiceInterface {

    @Autowired
    UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public void updateUser(User user, int id) {
        User tempUser = userRepository.findById(id).orElse(null);
        if(tempUser == null)return;
        tempUser.setName(user.getName());
        userRepository.save(tempUser);
    }
}
