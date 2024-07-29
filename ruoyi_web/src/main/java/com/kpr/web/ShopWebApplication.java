package com.kpr.web;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author 万先生
 * @version 1.0
 * Create by 2024/3/5 22:19
 */
@SpringBootApplication
@Slf4j
@MapperScan({"com.kpr.**.mapper"})
@ServletComponentScan("com.shop")
@ComponentScan(basePackages = {"com.kpr"})
@EnableCaching
public class ShopWebApplication  implements CommandLineRunner {

    @Override
    public void run(String... strings) throws Exception {
        log.info("移动端 - 启动完成");
    }

    public static void main(String[] args) {
        SpringApplication.run(ShopWebApplication.class, args);
    }

}
