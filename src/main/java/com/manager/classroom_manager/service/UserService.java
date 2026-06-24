package com.manager.classroom_manager.service;

import com.manager.classroom_manager.mapper.UserMapper;
import com.manager.classroom_manager.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    private UserMapper userMapper;
    
    /**
     * 用户登录验证
     */
    public User login(String username, String password) {
        User user = userMapper.findByUsername(username);
        
        if (user != null && user.getPassword().equals(password)) {
            // TODO: 实际项目中应该使用BCrypt等加密方式验证密码
            // if (user != null && BCrypt.checkpw(password, user.getPassword()))
            
            // 检查账户状态
            if ("active".equals(user.getStatus())) {
                return user;
            } else {
                throw new RuntimeException("账户状态异常，无法登录");
            }
        }
        
        return null;
    }
    
    /**
     * 根据ID获取用户信息
     */
    public User getUserById(Integer id) {
        return userMapper.findById(id);
    }
}
