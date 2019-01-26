package com.zhijiayun.common.exception;

import com.zhijiayun.common.base.BaseException;
import com.zhijiayun.common.constants.SystemConstants;

/**
 * @author juju chen
 * @description 自定义业务类异常
 * @date 2018/6/19 18:21
 */
public class BusinessException extends BaseException {

    private String code;

    public BusinessException() {
        super();
    }

    public BusinessException(Throwable ex) {
        super(ex);
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable ex) {
        super(message, ex);
    }

    /**
     * 用于应用层设置指定错误码
     * @param code
     * @param message
     */
    public BusinessException(String code,String message) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code == null?"500":code;
    }

}