package com.lcy.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lcy.dao.BookDao;
import com.lcy.dao.OrderDao;
import com.lcy.po.Book;
import com.lcy.po.Order;
import com.lcy.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 刘呈洋
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
    public void addShoppingCart(int businessId, int userId, String bookName, double price) {
        orderDao.addShoppingCart(businessId,userId,bookName,price);
    }
}
