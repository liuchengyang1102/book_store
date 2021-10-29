package com.lcy.dao;

import com.lcy.po.Business;
import org.apache.ibatis.annotations.Param;

/**
 * @author 刘呈洋
 */
public interface BusinessDao {
    /**
     * 用户登录
     */
    public Business businessLogin(@Param(value = "username") String username, @Param(value = "password") String password);
}
