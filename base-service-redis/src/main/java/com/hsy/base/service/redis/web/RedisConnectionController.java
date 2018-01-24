package com.hsy.base.service.redis.web;

import com.hsy.base.service.redis.service.IRedisService;
import com.hsy.java.bean.dto.ResponseBodyBean;
import com.hsy.java.bean.web.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path base-service/com.hsy.base.service.redis.web
 * @date 2018/1/24 21:13
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2018 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
@Api(value = "redis组件服务",description = "封装redisConnection下的方法")
@RestController
@RequestMapping("/api/rest/redis")
public class RedisConnectionController extends BaseController{

    @Autowired
    private IRedisService redisService ;

    @ApiOperation(value = "原子+1操作",notes = "将key原子性+1操作")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "key",value = "redis键key",required = true,dataType = "String"),
            @ApiImplicitParam(name = "expire",value = "redis过期时间，默认单位秒",dataType = "Long"),
    })
    @PostMapping("/v1/incr")
    public ResponseBodyBean<Long> incr(
            @RequestParam(value = "key") String key
    ){
        return success(redisService.incr(key));
    }
    @ApiOperation(value = "原子+1操作",notes = "将key原子性+1操作")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "key",value = "redis键key",required = true,dataType = "String"),
            @ApiImplicitParam(name = "expire",value = "redis过期时间，默认单位秒",dataType = "Long"),
    })
    @PostMapping("/v1/incrWithExpire")
    public ResponseBodyBean<Long> incr(
            @RequestParam(value = "key") String key,
            @RequestParam(value = "expire",required = false) Long expire
    ){
        return success(redisService.incr(key, expire));
    }
}
