package com.lcy.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lcy.dao.BookDao;
import com.lcy.dao.BusinessDao;
import com.lcy.dao.OrderDao;
import com.lcy.dao.UserDao;
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
    @Autowired
    private UserDao userDao;
    @Autowired
    private BusinessDao businessDao;
    @Autowired
    private BookDao bookDao;

    @Override
    public void addShoppingCart(int userId, int bookId, String bookName, double price) {
        int businessId = bookDao.queryBusinessId(bookId);
        orderDao.addShoppingCart(businessId, userId, bookId, bookName, price);
    }

    @Override
    public void deleteShoppingCart(int id) {
        orderDao.deleteShoppingCart(id);
    }

    @Override
    public void addBuy(int userId, int bookId, String bookName, double price) {
        int businessId = bookDao.queryBusinessId(bookId);
        orderDao.addBuy(businessId, userId, bookId, bookName, price);
    }

    @Override
    public void shoppingCartToBuy(int id) {
        orderDao.shoppingCartToBuy(id);
    }

    @Override
    public void pay(int id, int userId, double price) {
        if (userDao.pay(userId, price) == 1) {
            orderDao.pay(id);
        }
    }

    @Override
    public void sendGoods(int id) {
        //通过订单id查询图书id
        int bookId = orderDao.queryBookId(id);
        if (bookDao.sendGoods(bookId) == 1) {
            orderDao.sendGoods(id);
        }
    }

    @Override
    public void receive(int id, double price) {
        int businessId = orderDao.queryBusinessId(id);
        businessDao.receive(businessId, price);
        orderDao.receive(id);
    }

    @Override
    public Result<Order> queryOrder(int userId, Integer page, Integer limit, String state) {
        //传入参数，当前页、每页条数
        PageHelper.startPage(page, limit);
        List<Order> orders = orderDao.queryOrder(userId, state);
        //通过包装获取分页的其它值信息
        PageInfo<Order> pageInfo = new PageInfo<>(orders);
        return Result.bulid(0, pageInfo.getTotal(), orders);
    }

    @Override
    public Result<Order> businessQueryOrderAll(int businessId, Integer page, Integer limit) {
        //传入参数，当前页、每页条数
        PageHelper.startPage(page, limit);
        List<Order> orders = orderDao.businessQueryOrderAll(businessId);
        //通过包装获取分页的其它值信息
        PageInfo<Order> pageInfo = new PageInfo<>(orders);
        return Result.bulid(0, pageInfo.getTotal(), orders);
    }

    @Override
    public Result<Order> businessQueryOrder(int businessId, Integer page, Integer limit, String state) {
        //传入参数，当前页、每页条数
        PageHelper.startPage(page, limit);
        List<Order> orders = orderDao.businessQueryOrder(businessId, state);
        //通过包装获取分页的其它值信息
        PageInfo<Order> pageInfo = new PageInfo<>(orders);
        return Result.bulid(0, pageInfo.getTotal(), orders);
    }
}
