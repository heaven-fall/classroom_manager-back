package com.manager.classroom_manager.controller;

import com.manager.classroom_manager.model.Result;
import com.manager.classroom_manager.model.User;
import com.manager.classroom_manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {
    
    @Autowired
    private UserService userService;
    @PostMapping("/login")
    public Result<User> login(@RequestBody User user) {
        try {
            if (user.getUsername() == null || user.getUsername().trim().isEmpty()) {
                return Result.error("用户名不能为空");
            }
            
            if (user.getPassword() == null || user.getPassword().trim().isEmpty()) {
                return Result.error("用户名不能为空");
            }
            
            User user1 = userService.login(user.getUsername(), user.getPassword());
            
            if (user1 == null) {
                return Result.error("用户名或密码错误");
            }
            if (!user1.getStatus().equals(0)){
                return Result.error("账户状态异常，无法登录");
            }
            
        } catch (Exception e) {
            return Result.error("内部错误");
        }
        return null;
    }
    
    @PostMapping("/add")
    public Result<Boolean> addUser(@RequestBody User user){
        if (userService.addUser(user)){
            return Result.success(true);
        }
        return Result.error("用户名不能重复");
    }
    
    @PostMapping("/delete")
    public Result<Boolean> deleteUser(@RequestBody User user){
        if (userService.getUserById(user.getId()) == null){
            return Result.error("用户不存在");
        }
        return Result.success(userService.deleteUser(user.getId()));
    }
    
    @PostMapping("/update")
    public Result<Boolean> updateUser(@RequestBody User user){
        if (userService.updateUser(user)){
            return Result.success(true);
        }
        return Result.error("修改失败");
    }
    
    @GetMapping("/all")
    public Result<List<User>> getAllUsers(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize){
        return Result.success(userService.getAllUsers(pageNum, pageSize));
    }
}
