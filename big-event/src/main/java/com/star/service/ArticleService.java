package com.star.service;

import com.star.common.PageBean;
import com.star.pojo.Article;

/**
 * @Classname: ArticleService
 * @Date: 2024/12/2 18:43
 * @Author: 聂建强
 * @Description:
 */
public interface ArticleService {
    void add(Article article);  // 新增文章

    // 条件分页列表查询
    PageBean<Article> list(Integer pageNum, Integer pageSize, Integer categoryId, String state);
}
