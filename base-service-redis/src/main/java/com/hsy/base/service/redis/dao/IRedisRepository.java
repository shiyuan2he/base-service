package com.hsy.base.service.redis.dao;

import com.hsy.java.enums.CacheEnum;
import com.hsy.java.exception.cache.CacheException;
import com.hsy.java.util.cache.redis.impl.AbstractSpringRedisCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
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
public interface IRedisRepository{
    /**
     * @description <p>设置字符串</p>
     * @param k key
     * @param obj 
     * @return
     */
    <T> boolean setString(String k,Object obj) ;
    /**
     * @description <p>设置带有过期时间的字符串</p>
     * @param k 键
     * @param obj 值
     * @param expire 过期时间 单位：毫秒
     * @return 是否设置成功
     * @author heshiyuan
     * @date 2018/1/17 17:39
     */
    <T> boolean setStringWithExpire(String k,T obj,long expire) ;
    /**
     * @description <p>设置带有过期时间和单位</p>
     * @param k 键
     * @param v 值
     * @param expire 过期时间
     * @param timeUnit 过期时间单位
     * @return 是否设置成功
     * @author heshiyuan
     * @date 2018/1/17 17:41
     */
    <T> boolean setStringWithExpireAndTimeUnit(String k, T v, long expire, TimeUnit timeUnit) ;
    /**
     * @description <p>获取redis值</p>
     * @param k 键
     * @return 返回获取的值
     * @author heshiyuan
     * @date 2018/1/17 17:43
     */
    <T> T getStringValue(String k);
    /**
     * @description <p></p>
     * @param key 键
     * @param obj 值
     * @return  设置list
     * @author heshiyuan
     * @date 2018/1/17 17:44
     */
    <T> Long setList(String key,T obj);
    /**
     * @description <p></p>
     * @param key 键
     * @return 获取的list对象
     * @author heshiyuan
     * @date 2018/1/17 17:45
     */
    <T> T getList(String key);
    /**
     * @description <p>更新</p>
     * @param k 键
     * @param v 值
     * @return
     * @author heshiyuan
     * @date 2018/1/17 17:46
     */
    String updateString(String k,String v) ;
    /**
     * @description <p></p>
     * @param k
     * @return boolean 是否删除成功
     * @author heshiyuan
     * @date 2018/1/17 17:37
     */
    boolean delete(String k);
    /**
     * 判断缓存中是否有对应的value
     * @param key
     * @return
     */
    boolean exists(final String key);
}
