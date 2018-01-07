package com.hsy.base.service.image;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path base-service/PACKAGE_NAME
 * @date 2017/12/25 14:39
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ImageApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(ImageApplication.class)
                .web(true)
                .run(args)
                ;
    }
}
