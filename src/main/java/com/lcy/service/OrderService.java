package com.lcy.service;

import com.lcy.po.Order;
import com.lcy.util.Result;

/**
 * @author 刘呈洋
 */
public interface OrderService {
    /**
     * 添加购物车
     */
    public void addShoppingCart(int businessId, int userId, String bookName, double price);

    /**
     * 删除购物车
     */
    public void deleteShoppingCart(int id);

    /**
     * 添加待付款订单
     */
    public void addBuy(int businessId, int userId, String bookName, double price);

    /**
     * 从购物车添加待付款订单
     */
    public void shoppingCartToBuy(int id);

    /**
     * 查询购物车订单
     */
    public Result<Order> queryOrder(int userId, Integer page, Integer limit, String state);
}
