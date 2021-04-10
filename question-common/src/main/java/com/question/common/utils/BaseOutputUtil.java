package com.question.common.utils;

import com.question.common.entity.BaseOutput;
import com.question.common.enums.ResponseCode;
import org.apache.commons.lang.StringUtils;

/**
 * @Date 2021/4/7 22:40
 * @Created by liukaihua
 */

public class BaseOutputUtil {

    public static void setOutput(BaseOutput output,String code,String message){
        output.setMessage(message);
        output.setResultCode(code);
        output.setSuccess(StringUtils.equals(ResponseCode.TK00001.getCode(),code));
    }

}
