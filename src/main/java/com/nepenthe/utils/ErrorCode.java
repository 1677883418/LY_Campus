package com.nepenthe.utils;

/**
 * @author LengAo
 * @date 2021/10/11 11:11
 */
public enum  ErrorCode {
    /**
     * 服务未发现
     */
    ServiceNotFound("服务未发现", 404),
    /**
     * 系统内部错误
     */
    ServiceError("系统内部错误", 500),

    /**
     * 请求异常
     */
    BadRequst("请求异常", 400),

    /**
     * 无权限
     */
    ForbiddenRequst("无操作权限", 403),

    /**
     * 数据不能为空
     */
    DataNotNull("不能为空", -10000),
    /**
     * 操作失败
     */
    OperFail("操作失败", -20000),
    /**
     * 数据不满足要求
     */
    DataNotAllowed("数据不满足要求", -30000);

    /**
     * 错误信息
     */
    private String errorMsg;
    /**
     * 错误编码
     */
    private int errorCode;

    /**
     * 创建错误编码
     */
    private ErrorCode(String errorMsg, int errorCode) {
        this.errorMsg = errorMsg;
        this.errorCode = errorCode;
    }

    /**
     * 自定义信息
     * <p>
     * 返回自定义信息和错误预设信息的拼接
     *
     * @param cusMsg 自定义信息
     * @return
     */
    public String getErrorMsg(String cusMsg) {
        return cusMsg + errorMsg;
    }

    /**
     * @return the errorMsg
     */
    public String getErrorMsg() {
        return errorMsg;
    }

    /**
     * @return the errorCode
     */
    public int getErrorCode() {
        return errorCode;
    }

    @Override
    public String toString() {
        return this.errorCode + "_" + this.errorMsg;
    }
}
