package com.zhijiayun.common.base;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.plugins.Page;
import com.zhijiayun.common.util.DataTransform;

import lombok.Data;


/**
 * @author: jujun chen
 * @description:
 * @date: 2018/6/28
 */
@Data
public  class PageVo<T extends BaseVo> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 每页显示条数，默认 10
     */
    private int size = 10;


    /**
     * 当前页
     */
    private int current = 1;


    /**
     * 总数
     */
    private long total;


    /**
     * 查询数据列表
     */
    private List<T> records = Collections.emptyList();


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


    public PageVo() {
    }

    public PageVo(int size, int current) {
        this.size = size;
        this.current = current;
    }



    public PageVo(int size, int current, long total, List<T> records) {
        this.size = size;
        this.current = current;
        this.total = total;
        this.records = records;
    }



    public  <F extends BaseDo> PageVo(Page<F> page,Class<T> tClass){
        this.size = page.getSize();
        this.current = page.getCurrent();
        this.total = page.getTotal();
        this.records = DataTransform.doTvo(page.getRecords(), tClass);
    }







}
