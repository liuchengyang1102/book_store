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

    /**
     * 商家注册
     */
    public int addUser(@Param(value = "username") String username, @Param(value = "password") String password,
                       @Param(value = "name") String name);

    /**
     * 用户支付
     *
     * @param userId
     * @param price
     * @return
     */
    public int pay(@Param(value = "userId") int userId, @Param(value = "price") double price);

    /**
     * 查询余额
     *
     * @param id
     * @return
     */
    public List<User> queryBalance(@Param(value = "id") int id);

    /**
     * 用户充值
     */
    public void recharge(@Param(value = "id") int id, @Param(value = "money") int money);
}
