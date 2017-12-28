package com.hsy.base.service.redis.web;

import com.hsy.base.service.redis.service.IRedisService;
import com.hsy.java.bean.dto.ResponseBodyBean;
import com.hsy.java.bean.web.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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
@Api(value = "redis组件服务",description = "封装redis，对外提供redis组件服务")
@RestController
@RequestMapping("/api/rest/redis")
public class ObjectRedisController extends BaseController{

    @Autowired private IRedisService redisService ;

    /*@ApiOperation(value = "字符串set",notes = "添加字符串类型的值到redis")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "key",value = "redis键key",required = true,dataType = "String"),
            @ApiImplicitParam(name = "value",value = "redis键value",required = true,dataType = "String"),
            @ApiImplicitParam(name = "expire",value = "redis过期时间，默认单位秒",required = true,dataType = "Long"),
    })
    @PostMapping("/v1/object/set")
    public ResponseBodyBean<Boolean> setObjectValue(
            @RequestParam(value = "key") String key,
            @RequestParam(value = "value") Object value,
            @RequestParam(value = "expire") Long expire
    ){
        return success(redisService.setObjectValue(key, value, expire));
    }

    @ApiOperation(value = "get操作",notes = "从字符串获取string类型的值")
    @ApiImplicitParam(name = "key",value = "redis键key",required = true,dataType = "String",paramType = "path")
    @GetMapping(value = {"/v1/string/get","/v1/string/{key}/get"})
    public ResponseBodyBean<Object> getObjectValue(
            @RequestParam(value = "key") String key){
        return success(redisService.getObjectValue(key));
    }

    @ApiOperation(value = "删除",notes = "删除object类型的数据")
    @ApiImplicitParam(name = "key",value = "redis键key",required = true,dataType = "String",paramType = "path")
    @PutMapping(value = {"/v1/delete","/v1/{key}/delete"})
    public ResponseBodyBean<Boolean> deleteObjectKey(@RequestParam(value = "key") String key){
        return success(redisService.deleteObjectValue(key));
    }*/
}