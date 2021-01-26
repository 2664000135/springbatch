package com.test.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author清梦
 * @site www.xiaomage.com
 * @company xxx公司
 * @create 2020-10-22 22:55
 */
@SpringBootApplication
@MapperScan(basePackages = "com.test.springboot.mapper")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
