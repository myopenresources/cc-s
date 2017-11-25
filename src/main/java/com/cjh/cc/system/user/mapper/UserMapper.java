package com.cjh.cc.system.user.mapper;

import com.cjh.cc.system.user.model.UserBean;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户
 */
@Mapper
public interface UserMapper {

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
