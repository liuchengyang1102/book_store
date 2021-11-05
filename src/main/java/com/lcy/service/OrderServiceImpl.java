package com.lcy.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lcy.dao.OrderDao;
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
        orderDao.addShoppingCart(businessId, userId, bookName, price);
    }

    @Override
    public Result<Order> queryOrder(int userId, Integer page, Integer limit, String state) {
        //传入参数，当前页、每页条数
        PageHelper.startPage(page, limit);
        List<Order> orders = orderDao.queryOrder(userId, page, limit, state);
        //通过包装获取分页的其它值信息
        PageInfo<Order> pageInfo = new PageInfo<>(orders);
        return Result.bulid(0, pageInfo.getTotal(), orders);
    }
}
