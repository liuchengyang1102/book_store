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
     * 查询购物车订单
     */
    public Result<Order> queryOrder(int userId, Integer page, Integer limit);
}
