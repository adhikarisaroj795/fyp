package com.vega.RoomFinder.controller;

import com.vega.RoomFinder.model.User;
import com.vega.RoomFinder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/users")

public class UserController {


    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAll(){
        return userService.getAllUsers();
    }
}
