package com.star.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.groups.Default;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class Category {
    @NotNull(groups = Update.class)
    private Integer id; // 主键ID
    // @NotEmpty(groups = {Add.class,Update.class})  // validation非空校验
    @NotEmpty
    private String categoryName; // 分类名称
    // @NotEmpty(groups = {Add.class,Update.class})  // validation非空校验
    @NotEmpty
    private String categoryAlias; // 分类别名
    private Integer createUser; // 创建人ID
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")  // 日期格式化
    private LocalDateTime createTime; // 创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")  // 日期格式化
    private LocalDateTime updateTime; // 更新时间

    // 1.如果说某个检验项没有指定分组，默认属于Default分组
    // 2.分组之间可以继承， A extends B  那么A中拥有B中所有的检验项

    // 校验分组：添加组
    public interface Add extends Default {}

    // 校验分组：更新组
    public interface Update extends Default{}
}
