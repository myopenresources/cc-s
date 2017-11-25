package com.cjh.cc.system.user.service;

import com.cjh.cc.system.user.model.UserBean;

/**
 * 用户
 */
public interface UserService {

    /**
     * 登录
     * @param user
     * @return
     */
    public UserBean  login(UserBean user);

    /**
     * 保存用户
     * @param user
     * @return
     */
    public Integer saveUser(UserBean user);
}
