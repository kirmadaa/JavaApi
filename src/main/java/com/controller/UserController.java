package com.controller;

import com.model.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/addUser")
    public String add(@RequestBody User user){
        userService.saveUser(user);
        return "New user has been added";
    }

    @GetMapping("/getAllUsers")
    public Iterable<User> getAllUsersFrom() {
        return userService.getAllUsers();
    }

    @GetMapping("/getById/{id}")
    public User getUser(@PathVariable("id") int id){
        return userService.getUserById(id);
    }

    @DeleteMapping(value = "/deleteById/{id}")
    public void delete(@PathVariable("id") int id){
        userService.deleteUser(id);
    }

    @PutMapping("/update/{id}")
    public String updateUser(@RequestBody User user, @PathVariable("id") int id){
        userService.updateUser(user, id);
        return "User updated";
    }
}
