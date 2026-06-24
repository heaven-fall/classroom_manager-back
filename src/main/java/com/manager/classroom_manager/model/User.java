package com.manager.classroom_manager.model;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    private String realName;
    private String email;
    private String phone;
    private Integer role;
    private Integer status;
    private String avatarUrl;
    private LocalDateTime lastLoginTime;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
