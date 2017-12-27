package com.hsy.base.service.redis.dao;
import com.hsy.java.enums.CacheEnum;
import com.hsy.java.exception.cache.CacheException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

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
public class SingleRedisRepository {

    @Autowired private StringRedisTemplate stringRedisTemplate ;

    @Autowired private RedisTemplate redisTemplate ;

    public boolean setString(String k,String v){
        boolean flag = false ;
        try{
            ValueOperations<String,String> ops = stringRedisTemplate.opsForValue() ;
            ops.set(k,v);
            flag = true ;
        }catch(Exception e){
            throw new CacheException(CacheEnum.CACHE_HANDLE_SET_EXCEPTION) ;
        }
        return flag ;
    }

    public boolean setStringWithExpire(String k,String v,long expire){
        boolean flag = false ;
        try{
            ValueOperations<String,String> ops = stringRedisTemplate.opsForValue() ;
            ops.set(k,v,expire);
            flag = true ;
        }catch(Exception e){
            throw new CacheException(CacheEnum.CACHE_HANDLE_SET_EXCEPTION) ;
        }
        return flag ;
    }

    public boolean setStringWithExpireAndTimeUnit(String k, String v, long expire, TimeUnit timeUnit){
        boolean flag = false ;
        try{
            ValueOperations<String,String> ops = stringRedisTemplate.opsForValue() ;
            ops.set(k,v,expire,timeUnit);
            flag = true ;
        }catch(Exception e){
            throw new CacheException(CacheEnum.CACHE_HANDLE_SET_EXCEPTION) ;
        }
        return flag ;
    }

    public String getString(String k){
        String value = null ;
        try{
            ValueOperations<String,String> ops = stringRedisTemplate.opsForValue() ;
            value = ops.get(k) ;
        }catch(Exception e){
            throw new CacheException(CacheEnum.CACHE_HANDLE_GET_EXCEPTION) ;
        }
        return value ;
    }

    public String updateString(String k,String v){
        String value = null ;
        try{
            ValueOperations<String,String> ops = stringRedisTemplate.opsForValue() ;
            value = ops.getAndSet(k,v) ;
        }catch(Exception e){
            throw new CacheException(CacheEnum.CACHE_HANDLE_SET_EXCEPTION) ;
        }
        return value ;
    }

    public boolean deleteString(String k){
        boolean flag = false ;
        try{
            stringRedisTemplate.delete(k);
            flag = true ;
        }catch(Exception e){
            throw new CacheException(CacheEnum.CACHE_HANDLE_DELETE_EXCEPTION) ;
        }
        return flag ;
    }

    public boolean setObject(String k,Object v){
        boolean flag = false ;
        try{
            ValueOperations<String,Object> ops = redisTemplate.opsForValue();
            ops.set(k,v);
            flag = true ;
        }catch(Exception e){
            throw new CacheException(CacheEnum.CACHE_HANDLE_SET_EXCEPTION) ;
        }
        return flag ;
    }

    public boolean setObjectWithExpire(String k,String v,long expire){
        boolean flag = false ;
        try{
            ValueOperations<String,Object> ops = redisTemplate.opsForValue() ;
            ops.set(k,v,expire);
            flag = true ;
        }catch(Exception e){
            throw new CacheException(CacheEnum.CACHE_HANDLE_SET_EXCEPTION) ;
        }
        return flag ;
    }

    public boolean setObjectWithExpireAndTimeUnit(String k, Object v, long expire, TimeUnit timeUnit){
        boolean flag = false ;
        try{
            ValueOperations<String,Object> ops = redisTemplate.opsForValue() ;
            ops.set(k,v,expire,timeUnit);
            flag = true ;
        }catch(Exception e){
            throw new CacheException(CacheEnum.CACHE_HANDLE_SET_EXCEPTION) ;
        }
        return flag ;
    }
    public Object getObject(String k){
        Object value = null ;
        try{
            ValueOperations<String,Object> ops = redisTemplate.opsForValue() ;
            value = ops.get(k) ;
        }catch(Exception e){
            throw new CacheException(CacheEnum.CACHE_HANDLE_GET_EXCEPTION) ;
        }
        return value ;
    }
    public boolean deleteObject(String k){
        boolean flag = false ;
        try{
            redisTemplate.delete(k);
            flag = true ;
        }catch(Exception e){
            throw new CacheException(CacheEnum.CACHE_HANDLE_DELETE_EXCEPTION) ;
        }
        return flag ;
    }
}
