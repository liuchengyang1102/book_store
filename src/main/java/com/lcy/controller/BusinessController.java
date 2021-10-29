package com.lcy.controller;

import com.lcy.po.Business;
import com.lcy.service.BusinessService;
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
public class BusinessController {
    private final static Log logger = LogFactory.getLog(BusinessController.class);

    @Autowired
    private BusinessService businessService;

    @RequestMapping("/business")
    public String businessHome() {
        return "/business";
    }

    @RequestMapping("businessLogin")
    @ResponseBody
    public Result<Business> businessLogin(String username, String password, HttpServletRequest request) {
        logger.debug("username:" + username + ",password:" + password);
        Result<Business> businessResult = businessService.businessLogin(username, password);
        logger.debug("businessResult:" + businessResult.getTotal());
        if (businessResult != null) {
            Business business = (Business) businessResult.getData();
            request.getSession().setAttribute("loginBusiness", business);
        }
        return businessResult;
    }
}
