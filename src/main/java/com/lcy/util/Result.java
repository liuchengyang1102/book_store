package com.lcy.util;

import java.io.Serializable;
import java.util.List;

public class Result<T> implements Serializable {
    private Integer code;
    private Object data;
    private Long total;     //分页信息，总条数

    public Result(Integer code, Object data, Long total) {
        this.code = code;
        this.data = data;
        this.total = total;
    }

    public static <T> Result<T> bulid(Integer code, Long total, List<T> data) {
        return new Result(code, data, total);
    }

    public static <T> Result<T> bulid2(Integer code, Long total, Object data) {
        return new Result(code, data, total);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long count) {
        this.total = total;
    }
}
