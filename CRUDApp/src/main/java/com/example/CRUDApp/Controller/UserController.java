package com.example.CRUDApp.Controller;


import com.example.CRUDApp.Model.User;
import com.example.CRUDApp.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    //To add User
    @PostMapping("/add")
    public String createUser(@RequestBody User user)
    {
        return userService.addUser(user);
    }

    //To get a user by id
    @GetMapping("/get/{id}")
    public User getUser(@PathVariable("id") int id)
    {
       return userService.getUser(id);
    }

    // Get all users
    @GetMapping("/get")
    public List<User> getAllUsers()
    {
       return userService.getAllUsers();
    }

    //To delete a user
    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id)
    {
        return userService.deleteUser(id);
    }

    //To update a user
    @PutMapping("/update/{id}")
    public User updateUser(@RequestBody User user, @PathVariable("id") Integer id)
    {
        return userService.updateUser(user, id);
    }
}
