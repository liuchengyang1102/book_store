package com.lcy.controller;

import com.lcy.po.User;
import com.lcy.service.UserService;
import com.lcy.util.Result;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 刘呈洋
 */
@Controller
public class UserController {
    private final static Log logger = LogFactory.getLog(BookController.class);

    @Autowired
    private UserService userService;

    @RequestMapping("userRegister")
    public String userRegister() {
        return "/userRegister";
    }

    @RequestMapping("userLogin")
    @ResponseBody
    public Result<User> userLogin(String username, String password, HttpServletRequest request) {
        logger.debug("username:" + username + ",password:" + password);
        Result<User> userResult = userService.userLogin(username, password);
        logger.debug("userResult:" + userResult.getTotal());
        if (userResult != null) {
            User user = (User) userResult.getData();
            request.getSession().setAttribute("loginUser", user);
        }
        return userResult;
    }

    @PostMapping("addUser")
    @ResponseBody
    public int addUser(String username, String password, String name) {
        logger.debug("username:" + username + ",password:" + password + ",name:" + name);
        return userService.addUser(username, password, name);
    }
}
