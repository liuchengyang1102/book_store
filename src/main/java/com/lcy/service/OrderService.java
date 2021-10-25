package com.lcy.service;

/**
 * @author 刘呈洋
 */
public interface OrderService {
    /**
     * 添加购物车
     */
    public void addShoppingCart(int businessId, int userId, String bookName, double price);
}
