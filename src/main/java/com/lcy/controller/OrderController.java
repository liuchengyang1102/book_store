package com.lcy.controller;

import com.lcy.po.Order;
import com.lcy.service.OrderService;
import com.lcy.service.UserService;
import com.lcy.util.Result;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

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
    public void addShoppingCart(int businessId, int userId, String bookName, double price) {
        logger.debug("businessId:" + businessId + ",userId:" + userId + ",bookName:" + bookName + ",price:" + price);
        orderService.addShoppingCart(businessId, userId, bookName, price);
    }
}
