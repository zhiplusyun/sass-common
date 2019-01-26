package com.zhijiayun.common.annotation;

import java.lang.annotation.*;

/**
 * @author zhangyu
 * @description 微信授权token校验
 * @date 2018/7/16 下午4:09
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface WechatAuth {
}
