package com.anno;



import com.config.CommonImportSelector;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解，用于组合@Import(CommonImportSelector.class)注解
 */
@Target(ElementType.TYPE)  // 元注解，表示当前注解可以在类上面使用
@Retention(RetentionPolicy.RUNTIME)  // 元注解，表示当前注解在运行时保留
@Import(CommonImportSelector.class)  // 需要组合的注解@Import(CommonImportSelector.class)
public @interface EnableCommonConfig {
}
