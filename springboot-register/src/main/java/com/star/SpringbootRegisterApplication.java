package com.star;


import com.anno.EnableCommonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;

@SpringBootApplication
// @Import({CommonConfig.class})  // 配置类导入,由于CommonConfig类与启动类不在一个包下，使用手动扫描,
// @Import(CommonImportSelector.class)  // 多个配置类导入,手动扫描，更加优雅的实现！！！将配置类统一写在另一个类里面，再导入该类
@EnableCommonConfig  // 自定义组合注解，让@Import(CommonImportSelector.class)注解更加优雅！！！！！！让代码更有逼格
public class SpringbootRegisterApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringbootRegisterApplication.class, args);

        //Country country = context.getBean(Country.class);
        //System.out.println(country);

        System.out.println(context.getBean("province"));
    }

}
