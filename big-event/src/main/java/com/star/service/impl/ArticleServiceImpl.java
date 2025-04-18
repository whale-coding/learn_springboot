package com.star.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.star.common.PageBean;
import com.star.mapper.ArticleMapper;
import com.star.pojo.Article;
import com.star.service.ArticleService;
import com.star.utils.ThreadLocalUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * @Classname: ArticleServiceImpl
 * @Date: 2024/12/2 18:43
 * @Author: 聂建强
 * @Description:
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Resource
    private ArticleMapper articleMapper;
    // 新增文章
    @Override
    public void add(Article article) {
        // 从ThreadLocal中获取载荷，即用户信息
        Map<String, Object> claims = ThreadLocalUtil.get();
        // 从载荷中获取登录用户的id
        Integer user_id = (Integer) claims.get("id");
        // 补充属性值
        article.setCreateTime(LocalDateTime.now());
        article.setUpdateTime(LocalDateTime.now());
        article.setCreateUser(user_id);

        articleMapper.add(article);
    }

    // 条件分页列表查询
    @Override
    public PageBean<Article> list(Integer pageNum, Integer pageSize, Integer categoryId, String state) {
        // 从ThreadLocal中获取载荷，即用户信息
        Map<String, Object> claims = ThreadLocalUtil.get();
        // 从载荷中获取登录用户的id
        Integer user_id = (Integer) claims.get("id");

        // 1.创建PageBean对象
        PageBean<Article> pageBean = new PageBean<>();

        // 2.开启分页查询 PageHelper
        PageHelper.startPage(pageNum, pageSize);

        // 3.调用mapper
        List<Article> articleList = articleMapper.list(user_id,categoryId, state);

        // Page中提供了方法，可以获取PageHelper分页查询后得到的总记录数和当前页数据
        Page<Article> page = (Page<Article>) articleList;

        // 把数据填充到PageBean对象中
        pageBean.setTotal(page.getTotal());
        pageBean.setItems(page.getResult());
        return pageBean;
    }
}
