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
     * 待付款订单付款
     *
     * @param id
     */
    void pay(@Param(value = "id") int id);

    /**
     * 订单发货
     *
     * @param id
     */
    void sendGoods(@Param(value = "id") int id);

    /**
     * 订单收货
     *
     * @param id
     */
    void receive(@Param(value = "id") int id);

    /**
     * 查询订单
     */
    List<Order> queryOrder(@Param(value = "userId") int userId, @Param(value = "state") String state);

    /**
     * 商家查看订单
     */
    List<Order> businessQueryOrderAll(@Param(value = "businessId") int businessId);

    /**
     * 待发货订单
     */
    List<Order> businessQueryOrder(@Param(value = "businessId") int businessId, @Param(value = "state") String state);
}
