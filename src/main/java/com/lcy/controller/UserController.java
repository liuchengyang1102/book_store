package com.lcy.controller;

import com.lcy.po.User;
import com.lcy.service.UserService;
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
public class UserController {
    private final static Log logger = LogFactory.getLog(BookController.class);

    @Autowired
    private UserService userService;

    @RequestMapping("userLogin")
    @ResponseBody
    public Result<User> userLogin(@RequestParam(defaultValue = "lcy")String username,@RequestParam(defaultValue = "1102") String password) {
        logger.debug("username:" + username + ",password:" + password);
        Result<User> user = userService.userLogin(username, password);
        logger.debug("user:" + user.getTotal());
        return user;
    }
}
