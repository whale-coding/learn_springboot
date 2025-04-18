package com.star.service.impl;

import com.star.mapper.CategoryMapper;
import com.star.pojo.Category;
import com.star.service.CategoryService;
import com.star.utils.ThreadLocalUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * @Classname: CategoryServiceImpl
 * @Date: 2024/12/2 15:20
 * @Author: 聂建强
 * @Description:
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Resource
    private CategoryMapper categoryMapper;

    // 新增分类
    @Override
    public void add(Category category) {
        // 从ThreadLocal中获取载荷，即用户信息
        Map<String, Object> claims = ThreadLocalUtil.get();
        // 从载荷中获取用户名
        Integer user_id = (Integer) claims.get("id");

        // 补充category中的属性值
        category.setCreateUser(user_id);
        category.setCreateTime(LocalDateTime.now());
        category.setUpdateTime(LocalDateTime.now());
        categoryMapper.add(category);
    }

    // 列表查询
    @Override
    public List<Category> list() {
        // 从ThreadLocal中获取载荷，即用户信息
        Map<String, Object> claims = ThreadLocalUtil.get();
        // 从载荷中获取登录用户的id
        Integer user_id = (Integer) claims.get("id");

        return categoryMapper.list(user_id);
    }

    // 根据id查询分类信息
    @Override
    public Category findById(Integer id) {
        return categoryMapper.findById(id);
    }

    // 更新分类
    @Override
    public void update(Category category) {
        // 设置更新时间
        category.setUpdateTime(LocalDateTime.now());

        categoryMapper.update(category);
    }
}
