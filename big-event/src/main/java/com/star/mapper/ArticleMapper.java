package com.star.mapper;

import com.star.pojo.Article;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Classname: ArticleMapper
 * @Date: 2024/12/2 18:44
 * @Author: 聂建强
 * @Description:
 */
@Mapper
public interface ArticleMapper {
    @Insert("insert into article(title, content, cover_img, state, category_id, create_user, create_time, update_time)" +
            " VALUES (#{title},#{content},#{coverImg},#{state},#{categoryId},#{createUser},#{createTime},#{updateTime})")
    void add(Article article);  // 新增

    List<Article> list(Integer userId, Integer categoryId, String state);  // 分页查询列表
}
