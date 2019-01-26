package com.zhijiayun.common.base;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import com.alibaba.fastjson.annotation.JSONField;

import lombok.Data;

/**
 * 数据模型基类
 */
@Data
public abstract class BaseVo  implements Serializable {
    private static final long serialVersionUID = 7258436689721815928L;

    /**
     * 主键
     */
    private Long id;


    /**
     * 每页显示条数，默认 10
     */
    @JSONField(serialize = false)
    private int size = 10;


    /**
     * 当前页
     */
    @JSONField(serialize = false)
    private int current = 1;


    /**
     * DESC ASC
     */
    @JSONField(serialize = false)
    private String order = "desc";


    /**
     * 排序字段
     */
    @JSONField(serialize = false)
    private String sidx = "id";


    public <T> T copyPropertiesTo(T target, String... ignoreProperties){
        BeanUtils.copyProperties(this,target,ignoreProperties);
        return target;
    }

    public static String[] getNullPropertyNames (Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<String>();
        for(java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) emptyNames.add(pd.getName());
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }

    public <T> T  copyPropertiesIgnoreNull(T target){
        BeanUtils.copyProperties(this, target, getNullPropertyNames(this));
        return target;
    }





}
