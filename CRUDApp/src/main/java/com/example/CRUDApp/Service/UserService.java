package com.example.CRUDApp.Service;


import com.example.CRUDApp.Model.User;
import com.example.CRUDApp.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public String addUser(User user)
    {
        try {
            userRepository.save(user);
        }
        catch (Exception e)
        {
            return "User could not be added";
        }
        return "User add successfully";
    }

    public User getUser(int id)
    {
        return userRepository.findById(id).get();
    }

    public List<User> getAllUsers()
    {
        return userRepository.findAll();
    }

    public String deleteUser(int id)
    {
        try {
            userRepository.deleteById(id);
        }
        catch (Exception e)
        {
            return "User could not be deleted";
        }
        return "User deleted successfully";
    }

    public User updateUser(User user, Integer id)
    {
        User user1 = userRepository.findById(id).get();
        user1.setFirstName(user.getFirstName());
        user1.setLastName(user.getLastName());
        userRepository.save(user1);
        return user1;
    }
}
