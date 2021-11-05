package com.lcy.dao;

import com.lcy.po.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 刘呈洋
 */
public interface OrderDao {
    /**
     * 添加购物车
     */
    void addShoppingCart(@Param(value = "businessId") int businessId, @Param(value = "userId") int userId,
                         @Param(value = "bookName") String bookName, @Param(value = "price") double price);

    /**
     * 查询购物车订单
     */
    List<Order> queryOrder(@Param(value = "userId") int userId, @Param(value = "page") Integer page,
                           @Param(value = "limit") Integer limit, @Param(value = "state") String state);
}
