package com.hsy.base.service.redis.web;

import com.hsy.base.service.redis.dao.SingleRedisRepository;
import com.hsy.java.bean.dto.ResponseBodyBean;
import com.hsy.java.bean.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path base-service/com.hsy.base.service.redis.web
 * @date 2017/12/26 16:57
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
@RestController
@RequestMapping("/api/rest/redis")
public class RedisController extends BaseController{

    @Autowired private SingleRedisRepository singleRedisRepository ;
    @PostMapping("/v1/set")
    public ResponseBodyBean<Boolean> setStringValue(
            @RequestParam(value = "key") String key,
            @RequestParam(value = "value") String value){
        return success(singleRedisRepository.setObject(key, value));
    }
    @GetMapping("/v1/get")
    public ResponseBodyBean<Object> getStringValue(
            @RequestParam(value = "key") String key){
        return success(singleRedisRepository.getObject(key));
    }
}
