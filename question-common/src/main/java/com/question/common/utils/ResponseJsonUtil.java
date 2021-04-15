package com.question.common.utils;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @Date 2021/4/15 8:41
 * @Created by liukaihua
 */

@Slf4j
public class ResponseJsonUtil {

    public static void printJson(HttpServletResponse response,String json){
        PrintWriter writer = null;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=UTF-8");
        try {
            writer = response.getWriter();
            writer.print(json);
        }catch (Exception e){
            log.error("输出json字符串-失败 throw error:{}",e);
        }finally {
            if (writer != null) {
                writer.close();
            }
        }
    }

}
