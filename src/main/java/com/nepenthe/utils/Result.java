package com.nepenthe.utils;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author LengAo
 * @date 2021/10/11 10:57
 */
public class Result<R> {

    @ApiModelProperty(value = "是否成功", position = 1)
    private boolean success;
    @ApiModelProperty(value = "响应编码", position = 2)
    private int code;
    @ApiModelProperty(value = "响应消息", position = 3)
    private String msg;
    @ApiModelProperty(value = "响应数据体", position = 4)
    private R data;

    private static String successMsg = "操作成功\uD83D\uDE3C";
    private static String failMsg = "操作失败\uD83D\uDE3F";

    public static <R> Result<R> ofSuccess() {
        return new Result<R>().setSuccess(true).setMsg(successMsg).setData(null);
    }

    public static <R> Result<R> ofSuccess(int code, String msg) {
        return new Result<R>().setSuccess(true).setMsg(msg).setData(null).setCode(code);
    }

    public static <R> Result<R> ofSuccess(R data) {
        return new Result<R>().setSuccess(true).setMsg(successMsg).setData(data);
    }

    public static <R> Result<R> ofSuccessWithMsg(R data, String msg) {
        return new Result<R>().setSuccess(true).setMsg(msg).setData(data);
    }

    public static <R> Result<R> ofSuccessMsg(String msg) {
        return new Result<R>().setSuccess(true).setMsg(msg);
    }

    public static <R> Result<R> ofFail() {
        return new Result<R>().setSuccess(false).setMsg(failMsg);
    }

    public static <R> Result<R> ofFail(int code, String msg) {
        Result<R> result = new Result<>();
        result.setSuccess(false);
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    public static <R> Result<R> ofFail(int code, String msg, R data) {
        return new Result<R>().setSuccess(false).setMsg(msg).setCode(code).setData(data);
    }

    public static <R> Result<R> ofFail(R data) {
        return new Result<R>().setSuccess(false).setMsg(failMsg).setData(data);
    }

    public static <R> Result<R> ofFail(String msg) {
        Result<R> result = new Result<>();
        result.setSuccess(false);
        result.setMsg(msg);
        return result;
    }

    public static <R> Result<R> ofFail(R data, String msg) {
        Result<R> result = new Result<>();
        result.setData(data);
        result.setSuccess(false);
        result.setMsg(msg);
        return result;
    }

    public static <R> Result<R> ofFail(ErrorCode error) {
        Result<R> result = new Result<>();
        result.setSuccess(false);
        result.setCode(error.getErrorCode());
        result.setMsg(error.getErrorMsg());
        return result;
    }

    /**
     * 定制消息和错误编码消息进行拼接
     *
     * @param <R>
     * @param error
     * @param customMsg
     * @return
     */
    public static <R> Result<R> ofFail(ErrorCode error, String customMsg) {
        Result<R> result = new Result<>();
        result.setSuccess(false);
        result.setCode(error.getErrorCode());
        result.setMsg(error.getErrorMsg(customMsg));
        return result;
    }

    public static <R> Result<R> ofThrowable(int code, Throwable throwable) {
        Result<R> result = new Result<>();
        result.setSuccess(false);
        result.setCode(code);
        result.setMsg(throwable.getClass().getName() + ", " + throwable.getMessage());
        return result;
    }

    public boolean isSuccess() {
        return success;
    }

    public Result<R> setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    public int getCode() {
        return code;
    }

    public Result<R> setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public Result<R> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public R getData() {
        return data;
    }

    public Result<R> setData(R data) {
        this.data = data;
        return this;
    }

    @Override
    public String toString() {
        return "Result{" + "success=" + success + ", code=" + code + ", msg='" + msg + '\'' + ", data=" + data + '}';
    }
}
