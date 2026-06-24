package com.manager.classroom_manager.service;

import com.manager.classroom_manager.mapper.UserMapper;
import com.manager.classroom_manager.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    
    @Autowired
    private UserMapper userMapper;
    
    public User login(String username, String password) {
        User user = userMapper.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
    
    public User getUserByName(String username){
        return userMapper.findByUsername(username);
    }
    public Boolean addUser(User user){
        if (userMapper.findByUsername(user.getUsername()) != null){
            return false;
        }
        return userMapper.addUser(user) > 0;
    }
    
    public List<User> getAllUsers(Integer pageNum, Integer pageSize){
        return userMapper.findAll(pageNum, pageSize);
    }
}
