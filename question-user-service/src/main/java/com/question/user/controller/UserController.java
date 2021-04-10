package com.question.user.controller;

import com.question.common.entity.BaseController;
import com.question.common.entity.BaseOutput;
import com.question.common.entity.BaseResponse;
import com.question.common.enums.ResponseCode;
import com.question.user.dto.QueryPermissionDTO;
import com.question.user.dto.QueryRoleDTO;
import com.question.user.dto.QueryUserDTO;
import com.question.user.dto.UserLoginDTO;
import com.question.user.entity.UserEntity;
import com.question.user.servcice.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @Date 2021/4/1 23:44
 * @Created by liukaihua
 */

@RestController
@Slf4j
@RequestMapping("user")
public class UserController extends BaseController {

    @Autowired
    private IUserService userService;

    /**
     * 登录验证提示
     * @return
     */
    @RequestMapping(value = "comeLogin",method = RequestMethod.GET)
    public BaseResponse comeLogin(){
        BaseResponse response = new BaseResponse();
        setResponse(response,ResponseCode.TK10004.getCode(),ResponseCode.TK10004.getMessage());
        return response;
    }

    /**
     * 鉴权
     * @param dto
     * @return
     */
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public BaseResponse login(@RequestBody @Valid UserLoginDTO dto,BindingResult result){
        log.info("用户登录鉴权-开始 请求参数:dto:{}",dto);
        BaseResponse response = new BaseResponse();
        try {
            if (result.hasErrors()) {
                return setResponseParamNull(result,response);
            }
            Subject subject = SecurityUtils.getSubject();
            if (subject.getPrincipal() != null) {
                UserEntity entity = (UserEntity) subject.getPrincipal();
                if (StringUtils.equals(entity.getAccount(), dto.getUserName())) {
                    setResponse(response,ResponseCode.TK10005.getCode(),ResponseCode.TK10005.getMessage());
                    return response;
                }
            }
            UsernamePasswordToken token = new UsernamePasswordToken(dto.getUserName(), dto.getPassword());
            subject.login(token);
            setResponse(response, ResponseCode.TK00001.getCode(),ResponseCode.TK00001.getMessage());
        }catch (UnknownAccountException e){
            setResponse(response, ResponseCode.TK10001.getCode(),ResponseCode.TK10001.getMessage());
        } catch (DisabledAccountException e){
            setResponse(response, ResponseCode.TK10002.getCode(),ResponseCode.TK10002.getMessage());
        } catch (IncorrectCredentialsException e){
            setResponse(response, ResponseCode.TK10003.getCode(),ResponseCode.TK10003.getMessage());
        } catch (Exception e){
            log.error("用户登录鉴权-异常 throw error:{}",e);
            setResponse(response, ResponseCode.TK00002.getCode(),ResponseCode.TK00002.getMessage());
        }finally {
            log.info("用户登录鉴权-结束 返回参数:response:{}",response);
        }
        return response;
    }

    /**
     * 根据账户查询用户信息
     * @param dto
     * @return
     */
    @RequestMapping(value = "queryUserByAccount",method = RequestMethod.POST)
    public BaseResponse queryUserByAccount(@RequestBody @Valid QueryUserDTO dto, BindingResult bindingResult){
        log.info("根据账户查询用户信息-开始 请求参数:dto:{}",dto);
        BaseResponse response = new BaseResponse();
        try {
            if (bindingResult.hasErrors()) {
                return setResponseParamNull(bindingResult,response);
            }
            BaseOutput output = userService.queryUserByAccount(dto.getAccount());
            if (!output.isSuccess()) {
                log.info("根据账户查询用户信息-失败 返回参数:output:{}",output);
                setResponse(response,output.getResultCode(),output.getMessage());
                return response;
            }
            response.setData(output.getData());
            setResponse(response, ResponseCode.TK00001.getCode(),ResponseCode.TK00001.getMessage());
        }  catch (Exception e){
            log.error("根据账户查询用户信息-异常 throw error:{}",e);
            setResponse(response, ResponseCode.TK00002.getCode(),ResponseCode.TK00002.getMessage());
        } finally {
            log.info("根据账户查询用户信息-结束 返回参数:response:{}",response);
        }
        return response;
    }

    /**
     * 根据用户id查询角色信息
     * @param dto
     * @param bindingResult
     * @return
     */
    @RequestMapping(value = "selectRoleByUserId",method = RequestMethod.POST)
    public BaseResponse selectRoleByUserId(@RequestBody @Valid QueryRoleDTO dto,BindingResult bindingResult){
        log.info("根据用户id查询角色信息-开始 请求参数:dto:{}",dto);
        BaseResponse response = new BaseResponse();
        try {
            if (bindingResult.hasErrors()) {
                return setResponseParamNull(bindingResult,response);
            }
            BaseOutput output = userService.selectRoleByUserId(dto.getUserId());
            if (!output.isSuccess()) {
                log.info("根据用户id查询角色信息-失败 返回参数:output:{}",output);
                setResponse(response,output.getResultCode(),output.getMessage());
                return response;
            }
            response.setData(output.getData());
            setResponse(response, ResponseCode.TK00001.getCode(),ResponseCode.TK00001.getMessage());
        }catch (Exception e){
            log.error("根据用户id查询角色信息-异常 throw error:{}",e);
            setResponse(response, ResponseCode.TK00002.getCode(),ResponseCode.TK00002.getMessage());
        }finally {
            log.info("根据用户id查询角色信息-结束 返回参数:response:{}",response);
        }
        return response;
    }

    /**
     * 根据角色id查询权限
     * @param dto
     * @param bindingResult
     * @return
     */
    @RequestMapping(value = "queryPermissionByRoleId",method = RequestMethod.POST)
    @RequiresPermissions(value = {"select","add","update"},logical = Logical.AND)
    @RequiresUser
    public BaseResponse queryPermissionByRoleId(@RequestBody @Valid QueryPermissionDTO dto, BindingResult bindingResult){
        log.info("根据角色id查询权限-开始 请求参数:dto:{}",dto);
        BaseResponse response = new BaseResponse();
        try {
            if (bindingResult.hasErrors()) {
                return setResponseParamNull(bindingResult,response);
            }
            BaseOutput output = userService.queryPermissionByRoleId(dto.getRoleIds());
            if (!output.isSuccess()) {
                log.info("根据角色id查询权限-失败 返回参数:output:{}",output);
                setResponse(response,output.getResultCode(),output.getMessage());
                return response;
            }
            response.setData(output.getData());
            setResponse(response, ResponseCode.TK00001.getCode(),ResponseCode.TK00001.getMessage());
        }catch (Exception e){
            log.error("根据角色id查询权限-异常 throw error:{}",e);
            setResponse(response, ResponseCode.TK00002.getCode(),ResponseCode.TK00002.getMessage());
        }finally {
            log.info("根据角色id查询权限-结束 返回参数:response:{}",response);
        }
        return response;
    }


}
