package com.vega.RoomFinder.service.impl;

import com.vega.RoomFinder.model.User;
import com.vega.RoomFinder.repository.UserRepository;
import com.vega.RoomFinder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

}
