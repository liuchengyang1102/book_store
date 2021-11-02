package com.lcy.service;

import com.lcy.po.Business;
import com.lcy.util.Result;

/**
 * @author 刘呈洋
 */
public interface BusinessService {
    /**
     * 商家登录
     */
    public Result<Business> businessLogin(String username, String password);

    /**
     * 商家注册
     */
    public void addBusiness(String userName, String password, String name, String address, String type,
                               double registeredCapital, String logPicture);
}
