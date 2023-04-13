package com.lhx.dm.user;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author hc
 * @version 1.0
 */

@SpringBootApplication
// @SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@ComponentScan(basePackages = "com.lhx")

public class DmApplication {
    public static void main(String[] args) {
        SpringApplication.run(DmApplication.class, args);
    }
}
