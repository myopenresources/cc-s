package com.cjh.cc.system.base.bean;

/**
 * 返回对象
 */
public class ResultBean {

    /**
     * 返回类型
     */
    private String  resultType;

    /**
     * 返回消息
     */
    private String  resultMsg;

    /**
     * 返回数据
     */
    private Object  resultData;

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public Object getResultData() {
        return resultData;
    }

    public void setResultData(Object resultData) {
        this.resultData = resultData;
    }
}
