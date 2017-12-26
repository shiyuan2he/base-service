package com.hsy.base.service.redis;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path base-service/com.hsy.base.service.redis
 * @date 2017/12/26 14:40
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
@SpringBootApplication
@EnableDiscoveryClient
public class RedisApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(RedisApplication.class)
                .web(true)
                .run(args)
                ;
    }
}
