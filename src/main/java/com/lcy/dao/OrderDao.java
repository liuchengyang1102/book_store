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
     * 删除购物车
     */
    void deleteShoppingCart(@Param(value = "id") int id);

    /**
     * 添加待付款订单
     */
    void addBuy(@Param(value = "businessId") int businessId, @Param(value = "userId") int userId,
                         @Param(value = "bookName") String bookName, @Param(value = "price") double price);

    /**
     * 从购物车添加待付款订单
     */
    void shoppingCartToBuy(@Param(value = "id") int id);

    /**
     * 查询购物车订单
     */
    List<Order> queryOrder(@Param(value = "userId") int userId, @Param(value = "page") Integer page,
                           @Param(value = "limit") Integer limit, @Param(value = "state") String state);
}
