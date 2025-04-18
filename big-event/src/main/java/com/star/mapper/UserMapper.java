package com.star.mapper;

import com.star.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @Classname: UserMapper
 * @Date: 2024/11/26 18:48
 * @Author: 聂建强
 * @Description:
 */
@Mapper
public interface UserMapper {
    @Select("select * from user where username = #{username}")
    User findUserByUsername(String username);  // 根据用户名查询用户信息

    @Insert("insert into user (username, password, create_time, update_time) values (#{username}, #{password}, now(), now())")
    void register(String username, String password);  // 用户注册
    @Update("update user set nickname=#{nickname}, email=#{email}, update_time=#{updateTime} where id=#{id}")
    void update(User user);  // 更新用户信息
    @Update("update user set user_pic=#{avatarUrl}, update_time=now() where id=#{id}")
    void updateAvatar(String avatarUrl, Integer id);  // 更新用户头像
    @Update("update user set password=#{md5Pwd}, update_time=now() where id=#{id}")
    void updatePwd(String md5Pwd, Integer id);  // 更新密码
}
