package com.star.service.impl;

import com.star.mapper.UserMapper;
import com.star.pojo.User;
import com.star.service.UserService;
import com.star.utils.Md5Util;
import com.star.utils.ThreadLocalUtil;
import jakarta.annotation.Resource;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * @Classname: UserServiceImpl
 * @Date: 2024/11/26 18:49
 * @Author: 聂建强
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    // 根据用户名查询用户信息
    @Override
    public User findUserByUsername(String username) {
        return userMapper.findUserByUsername(username);
    }

    // 注册
    @Override
    public void register(String username, String password) {
        // 对密码进行加密
        password = Md5Util.getMD5String(password);
        // 注册
        userMapper.register(username, password);

    }

    // 更新用户信息
    @Override
    public void update(User user) {
        user.setUpdateTime(LocalDateTime.now());  // 设置更新时间
        // 更新用户信息
        userMapper.update(user);
    }

    // 更新用户头像
    @Override
    public void updateAvatar(String avatarUrl) {
        // 从ThreadLocal中获取载荷，即用户信息
        Map<String, Object> claims = ThreadLocalUtil.get();
        // 从载荷中获取用户id
        Integer id = (Integer) claims.get("id");
        userMapper.updateAvatar(avatarUrl, id);
    }

    // 更新密码
    @Override
    public void updatePwd(String newPwd) {
        // 从ThreadLocal中获取载荷，即用户信息
        Map<String, Object> claims = ThreadLocalUtil.get();
        // 从载荷中获取用户id
        Integer id = (Integer) claims.get("id");
        String md5Pwd = Md5Util.getMD5String(newPwd);
        userMapper.updatePwd(md5Pwd,id);
    }
}
