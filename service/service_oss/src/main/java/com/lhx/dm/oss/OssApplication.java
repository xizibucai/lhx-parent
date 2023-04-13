package com.lhx.dm.oss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author hc
 * @version 1.0
 */

/**
 *  spring boot 会默认加载org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration这个类，
 *  而DataSourceAutoConfiguration类使用了@Configuration注解向spring注入了dataSource bean，
 *  又因为项目（oss模块）中并没有关于dataSource相关的配置信息，
 *   所以当spring创建dataSource bean时因缺少相关的信息就会报错。
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)//数据库没配置，所有要加exclude = DataSourceAutoConfiguration.class
@ComponentScan("com.lhx")
public class OssApplication {
    public static void main(String[] args) {
        SpringApplication.run(OssApplication.class,args);
    }
}
