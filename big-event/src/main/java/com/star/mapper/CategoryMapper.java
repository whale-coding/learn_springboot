package com.star.mapper;

import com.star.pojo.Category;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @Classname: CategoryMapper
 * @Date: 2024/12/2 15:20
 * @Author: 聂建强
 * @Description:
 */
@Mapper
public interface CategoryMapper {
    @Insert("insert into category(category_name, category_alias, create_user, create_time, update_time) " +
            "values(#{categoryName}, #{categoryAlias}, #{createUser}, #{createTime}, #{updateTime}) ")
    void add(Category category);  // 新增

    @Select("select * from category where create_user = #{userId}")
    List<Category> list(Integer userId);  // 查询所有

    @Select("select * from category where id = #{id}")
    Category findById(Integer id);  // 根据id查询

    @Update("update category set category_name = #{categoryName}, category_alias = #{categoryAlias}, update_time = #{updateTime} where id = #{id}")
    void update(Category category);  // 更新
}
