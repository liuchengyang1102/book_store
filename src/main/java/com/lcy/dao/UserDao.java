package com.lcy.dao;

import com.lcy.po.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author 刘呈洋
 */
public interface UserDao {
    /**
     * 用户登录
     */
    public User userLogin(@Param(value = "username") String username, @Param(value = "password") String password);

    /**
     * 商家注册
     */
    public int addUser(@Param(value = "username") String username, @Param(value = "password") String password,
                        @Param(value = "name") String name);
}
