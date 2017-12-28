package com.hsy.base.service.redis.service;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path base-service/com.hsy.base.service.redis.service
 * @date 2017/12/27 16:38
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public interface IRedisService {

    boolean setStringValue(String key,String value,Long expire) ;

    String getStringValue(String key);

    boolean deleteStringValue(String key) ;

    boolean setObjectValue(String key,Object value,Long expire) ;

    Object getObjectValue(String key);
}
