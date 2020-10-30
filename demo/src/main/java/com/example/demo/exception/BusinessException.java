package com.example.demo.exception;

/**
 * @author 王明卿
 * @version 1.0
 * @since 2019/4/30 10:41
 **/
public class BusinessException extends RuntimeException{

    private String errCode;
    private String errMsg;

    public BusinessException(){}

    public BusinessException(String errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public String getErrCode() {
        return errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }
}
