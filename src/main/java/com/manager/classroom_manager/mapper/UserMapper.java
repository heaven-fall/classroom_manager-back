package com.manager.classroom_manager.mapper;

import com.manager.classroom_manager.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    
    @Select("SELECT id,username,real_name,phone,role,state FROM users WHERE username = #{username}")
    User findByUsername(String username);
    
    @Select("SELECT * FROM users WHERE id = #{id}")
    User findById(Integer id);
    
    @Select("select id,username,real_name,phone,role,state from users limit #{pageSize} offset (#{pageNum}-1)*#{pageSize}")
    List<User> findAll(Integer pageNum, Integer pageSize);
    
    @Insert("insert into users(username,password,real_name,phone,role,state) set(#{username},#{password},#{realName},#{phone},#{role},#{state})")
    Integer addUser(User user);
    
}
