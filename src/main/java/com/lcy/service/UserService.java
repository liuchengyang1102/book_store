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
}
