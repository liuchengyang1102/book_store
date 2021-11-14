package com.lcy.controller;

import com.lcy.po.Order;
import com.lcy.service.OrderService;
import com.lcy.util.Result;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 刘呈洋
 */
@Controller
public class OrderController {
    private final static Log logger = LogFactory.getLog(OrderController.class);

    @Autowired
    private OrderService orderService;

    @RequestMapping("addShoppingCart")
    @ResponseBody
    public void addShoppingCart(int userId, int bookId, String bookName, double price) {
        logger.debug("userId:" + userId + ",bookId:" + bookId + ",bookName:" + bookName + ",price:" + price);
        orderService.addShoppingCart(userId, bookId, bookName, price);
    }

    @RequestMapping("deleteShoppingCart")
    @ResponseBody
    public void deleteShoppingCart(int id) {
        logger.debug("id:" + id);
        orderService.deleteShoppingCart(id);
    }

    @RequestMapping("shoppingCartToBuy")
    @ResponseBody
    public void shoppingCartToBuy(int id) {
        logger.debug("id:" + id);
        orderService.shoppingCartToBuy(id);
    }

    @RequestMapping("pay")
    @ResponseBody
    public void pay(int id, int userId, double price) {
        logger.debug("id:" + id + ",userId:" + userId + ",price:" + price);
        orderService.pay(id, userId, price);
    }

    @RequestMapping("sendGoods")
    @ResponseBody
    public void sendGoods(int id) {
        logger.debug("id:" + id);
        orderService.sendGoods(id);
    }

    @RequestMapping("receive")
    @ResponseBody
    public void receive(int id, double price) {
        logger.debug("id:" + id + ",price:" + price);
        orderService.receive(id, price);
    }

    @RequestMapping("addBuy")
    @ResponseBody
    public void addBuy(int userId, int bookId, String bookName, double price) {
        logger.debug("userId:" + userId + ",bookId:" + bookId + ",bookName:" + bookName + ",price:" + price);
        orderService.addBuy(userId, bookId, bookName, price);
    }

    @RequestMapping("queryOrder")
    @ResponseBody
    public Result<Order> queryOrder(@RequestParam(defaultValue = "-1") int userId, @RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "15") Integer limit, String state) {
        logger.debug("userId:" + userId);
        Result<Order> orders = null;
        orders = orderService.queryOrder(userId, page, limit, state);
        return orders;
    }

    @RequestMapping("businessQueryOrderAll")
    @ResponseBody
    public Result<Order> businessQueryOrderAll(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "15") Integer limit,
                                               @RequestParam(defaultValue = "-1") Integer businessId) {
        logger.debug("businessId:" + businessId);
        Result<Order> orders = null;
        orders = orderService.businessQueryOrderAll(businessId, page, limit);
        return orders;
    }

    @RequestMapping("businessQueryOrder")
    @ResponseBody
    public Result<Order> businessQueryOrder(@RequestParam(defaultValue = "-1") int businessId, @RequestParam(defaultValue = "1") Integer page,
                                            @RequestParam(defaultValue = "15") Integer limit, String state) {
        logger.debug("businessId:" + businessId);
        Result<Order> orders = null;
        orders = orderService.businessQueryOrder(businessId, page, limit, state);
        return orders;
    }
}
