package com.zhijiayun.common.util;

import com.zhijiayun.common.base.BaseDo;
import com.zhijiayun.common.base.BaseVo;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: jujun chen
 * @description: vo to do , do to vo
 * @date: 2018/6/29
 */
@Slf4j
public class DataTransform {

    public static <T extends BaseVo,F extends BaseDo> List<T> doTvo(List<F> source,Class<T> tClass){
        if(null == source) return new ArrayList<>();
        List<T> tList = new ArrayList<>(source.size());
        T target = null;
        try {
            for(F f : source){
                target = tClass.newInstance();
                tList.add(f.copyPropertiesTo(target));
            }
            return tList;
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }


    public static <T extends BaseDo,F extends BaseVo> List<T> voTdo(List<F> source,Class<T> tClass){
        if(null == source) return new ArrayList<>();
        List<T> tList = new ArrayList<>(source.size());
        T target = null;
        try {
            for(F f : source){
                target = tClass.newInstance();
                tList.add(f.copyPropertiesTo(target));
            }
            return tList;
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }

}
