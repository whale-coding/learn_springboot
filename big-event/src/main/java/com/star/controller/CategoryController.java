package com.star.controller;

import com.star.common.Result;
import com.star.pojo.Category;
import com.star.service.CategoryService;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Classname: CategoryController
 * @Date: 2024/12/2 15:19
 * @Author: 聂建强
 * @Description:
 */
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Resource
    private CategoryService categoryService;

    /**
     * 新增文章分类
     * @param category 文章分类
     * @return 是否新增成功
     */
    @PostMapping
    public Result add(@Validated(Category.Add.class) @RequestBody Category category){
        categoryService.add(category);
        return Result.success();
    }

    /**
     * 获取文章分类列表
     * @return 文章分类列表
     */
    @GetMapping
    public Result<List<Category>> list(){
        List<Category> categoryList =categoryService.list();
        return Result.success(categoryList);
    }

    /**
     * 获取文章分类详情
     * @param id 文章分类id
     * @return 文章分类详情
     */
    @GetMapping("/detail")
    public Result<Category> detail(Integer id){
        Category category =  categoryService.findById(id);
        return Result.success(category);
    }

    /**
     * 更新文章分类
     * @param category 要更新的文章分类
     * @return 是否更新成功
     */
    @PutMapping
    public Result update(@RequestBody @Validated(Category.Update.class) Category category){
        categoryService.update(category);
        return Result.success();
    }
}
