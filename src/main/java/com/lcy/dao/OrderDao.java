package com.lcy.dao;

import com.lcy.po.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author 刘呈洋
 */
public interface OrderDao {
    /**
     * 添加购物车
     */
    void addShoppingCart(@Param(value = "businessId") int businessId, @Param(value = "userId") int userId,
                                @Param(value = "bookName") String bookName, @Param(value = "price") double price);
}
