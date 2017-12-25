package com.hsy.base.service.image.config;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path base-service/com.hsy.base.service.image.config
 * @date 2017/12/25 16:15
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
@Configuration
public class CaptchaProducerConfig {
    @Bean
    public DefaultKaptcha captchaProducer(){
        DefaultKaptcha kaptcha = new DefaultKaptcha() ;
        kaptcha.setConfig(new Config(getProperties()));
        return kaptcha;
    }
    private Properties getProperties(){
        Properties properties = new Properties() ;
        properties.setProperty("kaptcha.border","yes");
        properties.setProperty("kaptcha.border.color","105,179,90");
        properties.setProperty("kaptcha.textproducer.font.color","blue");
        properties.setProperty("kaptcha.image.width","100");
        properties.setProperty("kaptcha.image.height","50");
        properties.setProperty("kaptcha.noise.impl","com.google.code.kaptcha.impl.NoNoise");
        properties.setProperty("kaptcha.textproducer.char.string","23456789abcdefghjklmnpqrstuvwxyzABCDEFGHJKLMNPKRSTUVWXYZ");
        properties.setProperty("kaptcha.textproducer.char.length","4");
        properties.setProperty("kaptcha.textproducer.font.names","宋体,楷体,微软雅黑");
        properties.setProperty("kaptcha.session.key","code");
        return properties;
    }
}
