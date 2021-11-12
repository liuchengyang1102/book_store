package com.lcy.service;

import com.lcy.po.User;
import com.lcy.util.Result;

/**
 * @author 刘呈洋
 */
public interface UserService {
    /**
     * 用户登录
     */
    public Result<User> userLogin(String username, String password);

    /**
     * 用户注册
     */
    public int addUser(String username, String password, String name);

    /**
     * 查询余额
     *
     * @param id
     * @return
     */
    public Result<User> queryBalance(int id, Integer page, Integer limit);

    /**
     * 用户充值
     */
    public void recharge(int id, int money);
}
