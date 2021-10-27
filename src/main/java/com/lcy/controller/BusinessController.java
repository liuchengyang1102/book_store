package com.lcy.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 刘呈洋
 */
@Controller
public class BusinessController {
    private final static Log logger = LogFactory.getLog(BusinessController.class);

    @RequestMapping("/business")
    public String businessHome() {
        return "/business";
    }
}
