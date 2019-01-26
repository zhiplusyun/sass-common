package com.zhijiayun.common.annotation;

import java.lang.annotation.*;

/**
 * 忽略返回对象统一格式化
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface IgnoreFormat {
}
