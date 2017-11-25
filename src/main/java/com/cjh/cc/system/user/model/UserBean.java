package com.cjh.cc.system.user.model;

import com.cjh.cc.system.base.bean.BaseBean;

/**
 * 用户
 */
public class UserBean extends BaseBean {

    /**
     * id
     */
    private Integer  userId;

    /**
     * 用户名
     */
    private String userName ;

    /**
     *密码
     */
    private String password;

    /**
     * 姓名
     */
    private String  realName;

    /**
     * 联系电话
     */
    private String telephone;

    /**
     * 邮箱
     */
    private String email;

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getRealName() {
        return realName;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getEmail() {
        return email;
    }
}
