/**
 * **********************************************************************************************************
 * 版权声明：该软件的知识产权归深圳德卡股份有限公司所有。
 * Copyright Statement: The software intellectual property is owned by ShenZhen Decard SmartCard Tech Co.,Ltd.
 * **********************************************************************************************************
 */
package com.decard.myrule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author dcb 284850653@qq.com
 * @version 1.0
 * @description 类作用描述
 * @createDate 2018/12/10 11:08
 */
@Configuration
public class MySelfRule {

    @Bean

    public IRule getRule() {
        return new RandomRule();
    }

}
