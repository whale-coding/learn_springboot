package com.star.service;

import com.star.pojo.Category;

import java.util.List;

/**
 * @Classname: CategoryService
 * @Date: 2024/12/2 15:20
 * @Author: 聂建强
 * @Description:
 */
public interface CategoryService {
    void add(Category category);  // 新增分类

    List<Category> list();  // 列表查询

    Category findById(Integer id);  // 根据id查询分类信息

    void update(Category category);  // 更新分类
}
