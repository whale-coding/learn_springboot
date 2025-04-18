package com.star.service;

import com.star.pojo.User;

/**
 * @Classname: UserService
 * @Date: 2024/11/26 18:48
 * @Author: 聂建强
 * @Description:
 */
public interface UserService {
    // 根据用户名查询用户信息
    User findUserByUsername(String username);
    // 注册
    void register(String username, String password);
    // 更新用户信息
    void update(User user);
    // 更新用户头像
    void updateAvatar(String avatarUrl);
    // 更新密码
    void updatePwd(String newPwd);
}
