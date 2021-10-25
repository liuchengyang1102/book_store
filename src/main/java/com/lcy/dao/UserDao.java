package com.lcy.dao;

import com.lcy.po.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 刘呈洋
 */
public interface UserDao {
    /**
     * 用户登录
     */
    public User userLogin(@Param(value = "username") String username, @Param(value = "password") String password);
}
