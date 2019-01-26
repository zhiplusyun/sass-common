package com.zhijiayun.common.constants;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: jujun chen
 * @description: 系统常量
 * @date: 2018/1/1
 */
public final class SystemConstants {
    /**
     * 缓存键值
     */
    public static final Map<Class<?>, String> CACHE_KEY_MAP = new ConcurrentHashMap<>();

    /**
     * 缓存命名空间前缀
     */
    public static final String CACHE_NAMESPACE_PREFIX = "zjy:";

    /**
     * 数据缓存
     */
    public static final String CACHE_DATA = CACHE_NAMESPACE_PREFIX + "data:";

    /**
     * 分布式锁
     */
    public static final String CACHE_LOCK = CACHE_NAMESPACE_PREFIX + "lock:";

    /**
     * Shiro缓存
     */
    public static final String CACHE_SHIRO = CACHE_NAMESPACE_PREFIX + "shiro:";


    /**
     * 当前用户
     */
    public static final String CURRENT_USER = "CURRENT_USER";


}
