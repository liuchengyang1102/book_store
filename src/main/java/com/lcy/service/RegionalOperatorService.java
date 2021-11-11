package com.lcy.service;

import com.lcy.po.RegionalOperator;
import com.lcy.util.Result;

/**
 * @author 刘呈洋
 */
public interface RegionalOperatorService {
    /**
     * 用户登录
     */
    public Result<RegionalOperator> regionalOperatorLogin(String userName, String password);
}
