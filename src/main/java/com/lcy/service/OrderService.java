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
    public void addShoppingCart(int businessId, int userId, int bookId, String bookName, double price);

    /**
     * 删除购物车
     */
    public void deleteShoppingCart(int id);

    /**
     * 添加待付款订单
     */
    public void addBuy(int businessId, int userId, int bookId, String bookName, double price);

    /**
     * 从购物车添加待付款订单
     */
    public void shoppingCartToBuy(int id);

    /**
     * 待付款订单付款
     */
    public void pay(int id, int userId, double price);

    /**
     * 订单发货
     */
    public void sendGoods(int id);

    /**
     * 订单收货
     */
    public void receive(int id, int businessId, double price);

    /**
     * 查询订单
     */
    public Result<Order> queryOrder(int userId, Integer page, Integer limit, String state);

    /**
     * 商家查看订单
     */
    public Result<Order> businessQueryOrderAll(int businessId, Integer page, Integer limit);

    /**
     * 待发货订单
     */
    public Result<Order> businessQueryOrder(int businessId, Integer page, Integer limit, String state);
}
