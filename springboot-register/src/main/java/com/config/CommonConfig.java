package com.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Classname: CommonConfig
 * @Date: 2024/11/25 19:43
 * @Author: 聂建强
 * @Description:
 */
@Configuration  // 标注这个类是配置类
public class CommonConfig {

    // 注入Country对象，赋值时获取yml配置文件中的变量
    @Bean
    //如果配置文件中配置了指定的信息,则注入,否则不注入
    @ConditionalOnProperty(prefix = "country",name = {"name","system"})  // 注册条件注解
    public Country country(@Value("${country.name}") String name,@Value("${country.system}") String system){
        Country country = new Country();
        country.setName(name);
        country.setSystem(system);
        return country ;
    }

    // 注入Province对象
    // @Bean("aa")  // 指定对象的名字
    // @Bean  // 使用默认的对象的名字，对象默认的名字是: 方法名
    // 如果方法的内部需要使用到ioc容器中已经存在的bean对象,那么只需要在方法上声明即可,spring会自动的注入
    // public Province province(){
    //     return new Province();
    // }

    //如果ioc容器中不存在Country,则注入Province,否则不注入
    @Bean
    // @ConditionalOnMissingBean(Country.class)  // 如果当前环境中存在DispatcherServlet类,则注入Province,否则不注入
    @ConditionalOnClass(name = "org.springframework.web.servlet.DispatcherServlet")  // 如果当前引入了web起步依赖,则环境中有DispatcherServlet,否则没有
    public Province province(){
        return new Province();
    }
}
