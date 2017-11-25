package com.cjh.cc.system.user.controller;

import com.cjh.cc.common.util.DigestUtil;
import com.cjh.cc.system.base.bean.ResultBean;
import com.cjh.cc.system.base.constants.CommonConstants;
import com.cjh.cc.system.user.model.UserBean;
import com.cjh.cc.system.user.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * 用户
 */
@RestController
@RequestMapping("/system/user")
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;


    @ApiOperation(value = "登录", notes = "用户登录")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResultBean  login(@RequestBody  UserBean user, HttpServletResponse response) {
        ResultBean resultBean = new ResultBean();
        try {
            if (null != user && !StringUtils.isEmpty(user.getUserName()) && !StringUtils.isEmpty(user.getPassword())) {
                user.setPassword(DigestUtil.getMd5String(user.getPassword()));
                UserBean userBean= this.userService.login(user);
                if(!StringUtils.isEmpty(userBean)){
                    if(!userBean.getStatus().equals(CommonConstants.STATUS_LOCK)){
                        //添加到到缓存

                        //添加登录日志

                        resultBean.setResultType(CommonConstants.RESULT_SUCCESS);
                        resultBean.setResultData(userBean);
                        resultBean.setResultMsg("登录成功！");
                        logger.info("登录成功！");
                    }else{
                        resultBean.setResultType(CommonConstants.RESULT_FAILURE);
                        resultBean.setResultMsg("用户已被禁用！");
                        logger.info("用户已被禁用！");
                    }
                }else{
                    resultBean.setResultType(CommonConstants.RESULT_FAILURE);
                    resultBean.setResultMsg("用户名和密码有误！");
                    logger.info("用户名和密码有误！");
                }
            } else {
                resultBean.setResultType(CommonConstants.RESULT_FAILURE);
                resultBean.setResultMsg("用户名和密码为空！");
                logger.info("用户名和密码为空！");
            }

        } catch (Exception e) {
            resultBean.setResultType(CommonConstants.RESULT_ERROR);
            resultBean.setResultMsg("登录失败！");
            e.printStackTrace();
            logger.error("登录失败,错误——>" + e);
        }
       return resultBean;
    }


    @ApiOperation(value = "保存用户", notes = "根据前端传过来的用户参数保存用户")
    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public ResultBean saveUser(@RequestBody  UserBean user,HttpServletResponse response){
        ResultBean resultBean = new ResultBean();
        try {
            if (null != user) {
                user.setPassword(DigestUtil.getMd5String(user.getPassword()));
                int result = this.userService.saveUser(user);
                if (result > 0) {
                    resultBean.setResultType(CommonConstants.RESULT_SUCCESS);
                    resultBean.setResultMsg("保存用户成功！");
                    logger.info("保存用户成功！");
                } else {
                    resultBean.setResultType(CommonConstants.RESULT_FAILURE);
                    resultBean.setResultMsg("保存用户未成功！");
                    logger.info("保存用户未成功！");
                }
            } else {
                resultBean.setResultType(CommonConstants.RESULT_FAILURE);
                resultBean.setResultMsg("保存用户未成功！");
                logger.info("保存用户未成功！");
            }

        } catch (Exception e) {
            resultBean.setResultType(CommonConstants.RESULT_ERROR);
            resultBean.setResultMsg("保存用户失败！");
            e.printStackTrace();
            logger.error("保存用户失败,错误——>" + e);
        }
        return resultBean;
    }
}

