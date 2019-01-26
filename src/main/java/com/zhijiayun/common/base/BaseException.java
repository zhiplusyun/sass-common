package com.zhijiayun.common.base;

/**
 * @author: jujun chen
 * @description: 异常处理基类
 * @date: 2018/1/1
 */
public abstract class BaseException extends RuntimeException {

    public BaseException(){}

    public BaseException(Throwable ex) {
        super(ex);
    }

    public BaseException(String message) {
        super(message);
    }

    public BaseException(String message, Throwable ex) {
        super(message, ex);
    }


}
