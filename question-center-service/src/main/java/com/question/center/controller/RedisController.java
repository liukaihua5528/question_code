package com.question.center.controller;

import com.question.center.utils.RedisUtil;
import com.question.common.entity.BaseController;
import com.question.common.entity.BaseResponse;
import com.question.user.dto.QueryUserDTO;
import com.question.user.feign.UserFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date 2021/4/1 21:14
 * @Created by liukaihua
 */

@RestController
public class RedisController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(RedisController.class);

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private UserFeignClient userFeignClient;


    @RequestMapping("setRedisKey")
    public BaseResponse setRedisKey(@RequestBody String key){
        logger.info("设置缓存-开始 请求参数:key:{}",key);
        QueryUserDTO dto = new QueryUserDTO();
        dto.setAccount("root");
        BaseResponse userResponse = userFeignClient.queryUserByAccount(dto);
        return userResponse;
    }

}
