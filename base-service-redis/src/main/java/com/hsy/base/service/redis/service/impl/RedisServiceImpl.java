package com.hsy.base.service.redis.service.impl;

import com.hsy.base.service.redis.dao.impl.RedisRepository;
import com.hsy.base.service.redis.service.IRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path base-service/com.hsy.base.service.redis.service.impl
 * @date 2017/12/27 16:39
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
@Service(value = "redisService")
public class RedisServiceImpl implements IRedisService{
    @Autowired private RedisRepository redisRepository ;

    @Override
    public boolean setStringValue(String key, String value, Long expire) {
        if(null==expire){
            return redisRepository.setString(key,value) ;
        }else{
            return redisRepository.setStringWithExpireAndTimeUnit(key,value,expire,TimeUnit.SECONDS) ;
        }
    }

    @Override
    public String getStringValue(String key) {
        return redisRepository.getStringValue(key) ;
    }

    @Override
    public boolean deleteStringValue(String key) {
        return redisRepository.delete(key);
    }

    @Override
    public boolean setObjectValue(String key, Object value, Long expire) {
        return false ;
    }

    @Override
    public Object getObjectValue(String key) {
        return false ;
    }

    @Override
    public Long incr(String key) {
        return redisRepository.incr(key);
    }

    @Override
    public Long incr(String key, Long expire) {
        return redisRepository.incr(key,expire);
    }
}
