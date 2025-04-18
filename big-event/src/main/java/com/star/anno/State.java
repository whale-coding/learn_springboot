package com.star.anno;

import com.star.validation.StateValidation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented  // 元注解，表示该注解可以抽取到帮助文档中
@Target({ElementType.FIELD})  // 元注解，标识该注解可以用在哪些地方
@Retention(RetentionPolicy.RUNTIME)  // 元注解，表示直接会在哪个阶段被保留
@Constraint(validatedBy = {StateValidation.class})  // 指定提供校验规则的类
public @interface State {
    // 提供校验失败后的提示信息
    String message() default "{state参数的值只能是已发布或者草稿}";
    // 指定分组
    Class<?>[] groups() default {};
    // 负载，获取到State注解的附加信息
    Class<? extends Payload>[] payload() default {};
}
