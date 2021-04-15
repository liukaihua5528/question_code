package com.question.user.interceptor;

import com.alibaba.fastjson.JSON;
import com.question.common.entity.BaseController;
import com.question.common.entity.BaseResponse;
import com.question.common.enums.ResponseCode;
import com.question.common.utils.ResponseJsonUtil;
import com.question.common.utils.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Date 2021/4/13 23:27
 * @Created by liukaihua
 */

@Component
@Slf4j
public class LoginInterceptor extends HandlerInterceptorAdapter {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String userName = request.getHeader("userName");
        String password = request.getHeader("password");
        log.info("请求头信息登录用户名:{},密码:{}",userName,password);
        if (StringUtil.isEmpty(userName) || StringUtil.isEmpty(password)) {
            log.error("用户名或密码为空");
            BaseResponse base = new BaseResponse();
            BaseController.setResponse(base, ResponseCode.TK10006.getCode(),ResponseCode.TK10006.getMessage());
            ResponseJsonUtil.printJson(response, JSON.toJSONString(base));
            return false;
        }
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        super.postHandle(request, response, handler, modelAndView);
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }


}
