package com.star.pojo;



import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class User {
    @NotNull  // validation参数校验，不为Null
    private Integer id; // 主键ID

    private String username; // 用户名
    @JsonIgnore  // 让springmvc把当前对象转换为json字符串的时候，忽略该属性即忽略password，最终的json字符串中就没有password这个属性了
    private String password; // 密码

    @NotEmpty  // validation参数校验，不为空
    @Pattern(regexp = "^\\S{1,10}$")  // validation参数校验，自定义昵称校验正则表达式
    private String nickname; // 昵称

    @NotEmpty  // validation参数校验，不为空
    @Email  // validation参数校验，邮箱校验
    private String email; // 邮箱

    private String userPic; // 用户头像地址
    private LocalDateTime createTime; // 创建时间
    private LocalDateTime updateTime; // 更新时间
}
