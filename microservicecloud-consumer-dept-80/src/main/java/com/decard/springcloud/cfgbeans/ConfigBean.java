package com.decard.springcloud.cfgbeans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Administrator on 2018/12/6.
 */
@Configuration
public class ConfigBean {

    @Bean
    public RestTemplate getRestTemplete() {
        return new RestTemplate();
    }
}
