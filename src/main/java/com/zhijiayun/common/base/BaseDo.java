package com.zhijiayun.common.base;

import java.io.Serializable;

import org.springframework.beans.BeanUtils;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import lombok.Data;

/**
 * 数据模型基类
 */
@Data
public abstract class BaseDo implements Serializable {
    private static final long serialVersionUID = 7258436689721815928L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.ID_WORKER)
    private Long id;


    public <T> T copyPropertiesTo(T target, String... ignoreProperties){
        BeanUtils.copyProperties(this,target,ignoreProperties);
        return target;
    }



}
