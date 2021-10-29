package com.lcy.service;

import com.lcy.po.Business;
import com.lcy.util.Result;

/**
 * @author 刘呈洋
 */
public interface BusinessService {
    /**
     * 用户登录
     */
    public Result<Business> businessLogin(String username, String password);
}
