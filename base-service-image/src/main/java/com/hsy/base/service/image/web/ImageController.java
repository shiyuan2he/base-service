package com.hsy.base.service.image.web;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.hsy.base.service.image.dao.RedisDao;
import com.hsy.base.service.image.dao.RedisInterfaceInvoke;
import com.hsy.java.bean.web.BaseController;
import com.hsy.java.enums.CacheEnum;
import com.hsy.java.java.base.utils.VerificationCodeHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author heshiyuan
 * @description <p>验证码</p>
 * @path sso/com.hsy.sso.web.better.web
 * @date 2017/10/27 10:40
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
@RestController
@RequestMapping("/api/base/service/image")
public class ImageController extends BaseController {

    private Logger _logger = LoggerFactory.getLogger(this.getClass()) ;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    RedisInterfaceInvoke redisInterfaceInvoke ;

    @RequestMapping(value = "/v1/code",method = RequestMethod.GET)
    public void getCode(HttpServletResponse response) throws IOException {
        _logger.info("【验证码生成器】正在生成验证码");
        VerificationCodeHelper verificationCodeHelper = VerificationCodeHelper.getInstance();
        String strCode = verificationCodeHelper.getStr() ;
        _logger.info("【验证码生成器】生成的验证码是：{}",strCode);
        strCode = strCode.toUpperCase() ;
        redisInterfaceInvoke.setStringValue(
                CacheEnum.CACHE_KEY_IMAGE_CODE.getCode() + strCode,
                strCode,
                CacheEnum.CACHE_KEY_IMAGE_CODE.getExpire()) ;
        _logger.info("【验证码生成器】生成验证码放入redis中，key={}",CacheEnum.CACHE_KEY_IMAGE_CODE.getCode() + strCode);
        ServletOutputStream outputStream = response.getOutputStream() ;
        ImageIO.write(verificationCodeHelper.getImage(),"JPEG",outputStream) ;
        outputStream.flush();
        outputStream.close();
        _logger.info("【验证码生成器】生成验证码完毕");
    }
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private Producer captchaProducer ;


    @RequestMapping(value = "/v1/kaptchaCode",method = RequestMethod.GET)
    public void kaptchaCode(HttpServletRequest request,HttpServletResponse response) throws IOException {
        _logger.info("【验证码生成器】正在生成验证码");
        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
        response.setContentType("image/jpeg");
        String capText = captchaProducer.createText().toUpperCase();
        _logger.info("【验证码生成器】生成的验证码是：{}",capText);
        request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);
        redisInterfaceInvoke.setStringValue(
                CacheEnum.CACHE_KEY_IMAGE_CODE.getCode() + capText,
                capText,
                CacheEnum.CACHE_KEY_IMAGE_CODE.getExpire()) ;
        _logger.info("【验证码生成器】生成验证码放入redis中，key={}",CacheEnum.CACHE_KEY_IMAGE_CODE.getCode() + capText);
        BufferedImage bi = captchaProducer.createImage(capText);
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(bi, "jpg", out);
        try {
            out.flush();
        } finally {
            out.close();
        }
        _logger.info("【验证码生成器】生成验证码完毕");
    }
}
