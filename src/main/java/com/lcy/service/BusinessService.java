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
    public int addBusiness(String userName, String password, String name, String address, String type,
                           double registeredCapital, String logPicture);

    /**
     * 查询待审核商家
     */
    public Result<Business> queryBusiness(String area, Integer page, Integer limit);

    /**
     * 审核通过
     */
    public void pass(int id);

    /**
     * 审核不通过
     */
    public void failed(int id);

    /**
     * 查询商家当前状态
     */
    public Result<Business> queryState(int id, Integer page, Integer limit);

    /**
     * 管理商家当前状态
     */
    public int businessManage(String state, int id);
}
