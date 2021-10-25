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
    public void addShoppingCart(int businessId, int userId, String bookName, double price) {
        logger.debug("businessId:" + businessId + ",userId:" + userId + ",bookName:" + bookName + ",price:" + price);
        orderService.addShoppingCart(businessId, userId, bookName, price);
    }

    @RequestMapping("queryOrder")
    @ResponseBody
    public Result<Order> queryOrder(@RequestParam(defaultValue = "-1") int userId, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "15") Integer limit) {
        logger.debug("userId:" + userId);
        Result<Order> orders = null;
        orders = orderService.queryOrder(userId, page, limit);
        return orders;
    }
}
