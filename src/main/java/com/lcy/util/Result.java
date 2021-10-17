package com.lcy.util;

import java.io.Serializable;
import java.util.List;

public class Result<T> implements Serializable {
    private Object data;
    private Long total;     //分页信息，总条数

    public Result(Object data, Long total) {
        this.data = data;
        this.total = total;
    }

    public static <T> Result<T> bulid(Long total, List<T> data) {
        return new Result(data, total);
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
