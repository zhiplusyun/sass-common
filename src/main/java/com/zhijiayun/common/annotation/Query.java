package com.zhijiayun.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解，查询的QueryService使用
 */
@Retention(RetentionPolicy.RUNTIME) 
@Target({ElementType.FIELD})
public @interface Query {
	public static final String EQUAL = "=";
	public static final String LIKE = "%*%";
	public static final String LEFTLIKE = "%*";
	public static final String RIGHTLIKE = "*%";
	public static final String MORE = ">";
	public static final String MOREEQUAL = ">=";
	public static final String LESS = "<";
	public static final String LESSEQUAL = "<=";
	public String type()default EQUAL;
	public String sqlColumn() default "";
}
