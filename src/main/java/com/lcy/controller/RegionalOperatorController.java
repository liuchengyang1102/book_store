package com.lcy.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 刘呈洋
 */
@Controller
public class RegionalOperatorController {
    private final static Log logger = LogFactory.getLog(RegionalOperatorController.class);

    @RequestMapping("aaa")
    public String regionalOperatorHome() {
        return "/regionalOperator";
    }
}
