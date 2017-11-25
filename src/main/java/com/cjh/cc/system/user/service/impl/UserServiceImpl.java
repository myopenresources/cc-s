package com.cjh.cc.system.user.service.impl;

import com.cjh.cc.system.user.mapper.UserMapper;
import com.cjh.cc.system.user.model.UserBean;
import com.cjh.cc.system.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * 登录
     * @param user
     * @return
     */
    public UserBean  login(UserBean user){
        return this.userMapper.login(user);
    }

    /**
     * 保存用户
     * @param user
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.REPEATABLE_READ)
    @Override
    public Integer saveUser(UserBean user){
        return this.userMapper.saveUser(user);
    }
}
