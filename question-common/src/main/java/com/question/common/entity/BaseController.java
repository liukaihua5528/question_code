package com.question.common.entity;

import com.question.common.enums.ResponseCode;
import org.apache.commons.lang.StringUtils;
import org.springframework.validation.BindingResult;

/**
 * @Date 2021/4/1 23:07
 * @Created by liukaihua
 */

public class BaseController {

    public static void setResponse(BaseResponse response,String resultCode,String message){
        response.setMessage(message);
        response.setResultCode(resultCode);
        response.setSuccess(StringUtils.equals(resultCode,ResponseCode.TK00001.getCode()));
    }

    public static BaseResponse setResponseParamNull(BindingResult bindingResult,BaseResponse response){
        setResponse(response,ResponseCode.TK00003.getCode(),bindingResult.getAllErrors().get(0).getDefaultMessage());
        return response;
    }

}
