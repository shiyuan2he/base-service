package com.hsy.base.service.redis.dao;
import com.hsy.java.enums.CacheEnum;
import com.hsy.java.exception.cache.CacheException;
import com.hsy.java.util.cache.redis.impl.AbstractSpringRedisCache;
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
public class RedisRepository<T> extends AbstractSpringRedisCache<T>{

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
        valueOperations = redisTemplate.opsForValue();
        listOperations = redisTemplate.opsForList();
        hashOperations = redisTemplate.opsForHash();
    }

    public boolean setString(String k,String v){
        try{
            valueOperations.set(k,v);
            return true ;
        }catch(Exception e){
            throw new CacheException(CacheEnum.CACHE_HANDLE_SET_EXCEPTION) ;
        }
    }

    public boolean setStringWithExpire(String k,String v,long expire){
        try{
            valueOperations.set(k,v,expire);
            return true ;
        }catch(Exception e){
            throw new CacheException(CacheEnum.CACHE_HANDLE_SET_EXCEPTION) ;
        }
    }

    public boolean setStringWithExpireAndTimeUnit(String k, String v, long expire, TimeUnit timeUnit){
        try{
            valueOperations.set(k,v,expire,timeUnit);
            return true ;
        }catch(Exception e){
            throw new CacheException(CacheEnum.CACHE_HANDLE_SET_EXCEPTION) ;
        }
    }

    public String getStringValue(String k){
        try{
            return (String) valueOperations.get(k) ;
        }catch(Exception e){
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
