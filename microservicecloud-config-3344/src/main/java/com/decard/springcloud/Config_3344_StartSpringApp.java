package com.decard.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Created by Administrator on 2018/12/12.
 */
@SpringBootApplication
@EnableConfigServer
public class Config_3344_StartSpringApp {

    public static void main(String[] args) {
        SpringApplication.run(Config_3344_StartSpringApp.class, args);
    }

}
