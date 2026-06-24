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
    
    public List<User> getAllUsers(Integer pageNum, Integer pageSize){
        return userMapper.findAll(pageNum, pageSize);
    }
    
    public User getUserByName(String username){
        return userMapper.findByUsername(username);
    }
    
    public User getUserById(Integer id){
        return userMapper.findById(id);
    }
    public Boolean addUser(User user){
        if (userMapper.findByUsername(user.getUsername()) != null){
            return false;
        }
        return userMapper.addUser(user) > 0;
    }
    
    public Boolean deleteUser(Integer id){
        return userMapper.deleteUser(id) > 0;
    }
    
    public Boolean updateUser(User user){
        User user1 = userMapper.findById(user.getId());
        if (user1 == null){
            return false;
        }
        User user2 = userMapper.findByUsername(user.getUsername());
        if (user2 == null || user2.getId() == user1.getId()){
            return userMapper.updateUser(user) > 0;
        }
        return false;
    }
    
}
