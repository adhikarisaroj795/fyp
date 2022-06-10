package com.vega.RoomFinder.controller;

import com.vega.RoomFinder.model.User;
import com.vega.RoomFinder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RestController
@RequestMapping("/users")

public class UserController {


    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAll()
    {
        return userService.getAllUsers();
    }
    @GetMapping("/{id}")
    public User findById(@PathVariable int id)
    {
        return userService.findById(id);
    }
    @PostMapping
    public User addUser(@RequestBody @Valid User user)
    {
        return userService.addUser(user);
    }


    @PutMapping
    public  User updateUser(@RequestBody @Valid User user)
    {
        return userService.updateUser(user);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id)
    {
        return userService.deleteUser(id);
    }



}
