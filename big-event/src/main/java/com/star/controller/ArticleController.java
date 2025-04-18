package com.star.controller;

import com.star.common.PageBean;
import com.star.common.Result;
import com.star.pojo.Article;
import com.star.service.ArticleService;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @Classname: ArticleController
 * @Date: 2024/11/26 20:05
 * @Author: 聂建强
 * @Description:
 */
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Resource
    private ArticleService articleService;

    /**
     * 新增文章
     * @param article 要新增的文章对象
     * @return 是否成功
     */
    @PostMapping
    public Result add(@RequestBody @Validated Article article){
        articleService.add(article);
        return Result.success();
    }

    /***
     * 文章列表查询
     * @param pageNum 当前页面
     * @param pageSize 页面大小
     * @param categoryId 类别ID
     * @param state 文章状态
     * @return PageBean对象
     */
    @GetMapping
    public Result<PageBean<Article>> list(
            Integer pageNum,
            Integer pageSize,
            @RequestParam(required = false) Integer categoryId,
            @RequestParam(required = false) String state
    ){
        System.out.println(pageNum);
        System.out.println(pageSize);
        System.out.println(categoryId);
        System.out.println(state);
        PageBean<Article> pageBeans = articleService.list(pageNum, pageSize, categoryId, state);
        return Result.success(pageBeans);
    }
}
