package com.lhx.dm.user;


import com.lhx.dm.user.netty.CoordinationNettyServer;
import com.lhx.dm.user.netty.WebSocketServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author hc
 * @version 1.0
 */

@SpringBootApplication
// @SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@ComponentScan(basePackages = "com.lhx")

public class DmApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(DmApplication.class, args);
    }
    @Autowired
    WebSocketServer webSocketServer;

    @Override
    public void run(String... args) throws Exception {
        webSocketServer.run();
    }
}
