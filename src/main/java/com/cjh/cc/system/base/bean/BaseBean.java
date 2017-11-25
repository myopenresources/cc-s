package com.cjh.cc.system.base.bean;

/**
 * 基础bean
 */
public class BaseBean {
    /**
     * 创建人id
     */
    private String  createUserId;

    /**
     * 创建人姓名
     */
    private String createRealName;

    /**
     * 修改人id
     */
    private String  updateUserId;

    /**
     * 修改人姓名
     */
    private String  updateRealName;

    /**
     * 创建时间
     */
    private String createDate;

    /**
     * 修改时间
     */
    private String  updateDate;

    /**
     * 状态(N正常，L锁定，D删除)
     */
    private String  status;


    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public void setCreateRealName(String createRealName) {
        this.createRealName = createRealName;
    }

    public void setUpdateUserId(String updateUserId) {
        this.updateUserId = updateUserId;
    }

    public void setUpdateRealName(String updateRealName) {
        this.updateRealName = updateRealName;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public String getCreateRealName() {
        return createRealName;
    }

    public String getUpdateUserId() {
        return updateUserId;
    }

    public String getUpdateRealName() {
        return updateRealName;
    }

    public String getCreateDate() {
        return createDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public String getStatus() {
        return status;
    }
}
