package com.hsy.base.service.redis.dao;
import com.hsy.java.enums.CacheEnum;
import com.hsy.java.exception.cache.CacheException;
import com.hsy.java.util.cache.redis.impl.AbstractSpringRedisCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path base-service/com.hsy.base.service.redis.dao
 * @date 2017/12/26 14:41
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
@Repository
public class RedisRepository extends AbstractSpringRedisCache {
    private final Logger _logger = LoggerFactory.getLogger(this.getClass()) ;
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    private ValueOperations<String,Object> valueOperations;
    private ListOperations<String,Object> listOperations;
    private HashOperations hashOperations;

    @Override
    public RedisTemplate<String, Object> getRedisTemplate() {
        return redisTemplate;
    }

    @PostConstruct
    public void getValueOperation(){
        _logger.info("正在初始化valueOperations，listOperations，hashOperations");
        valueOperations = redisTemplate.opsForValue();
        listOperations = redisTemplate.opsForList();
        hashOperations = redisTemplate.opsForHash();
    }

    public <T> boolean setString(String k,Object obj){
        try{
            valueOperations.set(k,obj);
            return true ;
        }catch(Exception e){
            e.printStackTrace();
            throw new CacheException(CacheEnum.CACHE_HANDLE_SET_EXCEPTION) ;
        }
    }

    public <T> boolean setStringWithExpire(String k,T obj,long expire){
        try{
            valueOperations.set(k,obj,expire);
            return true ;
        }catch(Exception e){
            throw new CacheException(CacheEnum.CACHE_HANDLE_SET_EXCEPTION) ;
        }
    }

    public <T> boolean setStringWithExpireAndTimeUnit(String k, T v, long expire, TimeUnit timeUnit){
        try{
            valueOperations.set(k,v,expire,timeUnit);
            return true ;
        }catch(Exception e){
            throw new CacheException(CacheEnum.CACHE_HANDLE_SET_EXCEPTION) ;
        }
    }

    public <T> T getStringValue(String k){
        try{
            return (T) valueOperations.get(k) ;
        }catch(Exception e){
            throw new CacheException(CacheEnum.CACHE_HANDLE_GET_EXCEPTION) ;
        }
    }

    public <T> Long setList(String key,T obj){
        try {
            return listOperations.leftPush(key,obj);
        } catch (Exception e) {
            throw new CacheException(CacheEnum.CACHE_HANDLE_SET_EXCEPTION) ;
        }
    }

    public <T> T getList(String key){
        try {
            return (T) listOperations.leftPop(key) ;
        } catch (Exception e) {
            throw new CacheException(CacheEnum.CACHE_HANDLE_GET_EXCEPTION) ;
        }
    }

    public String updateString(String k,String v){
        try{
            return (String) valueOperations.getAndSet(k,v) ;
        }catch(Exception e){
            throw new CacheException(CacheEnum.CACHE_HANDLE_SET_EXCEPTION) ;
        }
    }

    public boolean delete(String k){
        try{
            redisTemplate.delete(k);
            return true ;
        }catch(Exception e){
            throw new CacheException(CacheEnum.CACHE_HANDLE_DELETE_EXCEPTION) ;
        }
    }
}
