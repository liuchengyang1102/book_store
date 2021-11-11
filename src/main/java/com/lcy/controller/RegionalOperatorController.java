package com.lcy.controller;

import com.lcy.po.RegionalOperator;
import com.lcy.service.RegionalOperatorService;
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
public class RegionalOperatorController {
    private final static Log logger = LogFactory.getLog(RegionalOperatorController.class);

    @Autowired
    private RegionalOperatorService regionalOperatorService;

    @RequestMapping("aaa")
    public String regionalOperatorHome() {
        return "/regionalOperator";
    }

    @RequestMapping("regionalOperatorLogin")
    @ResponseBody
    public Result<RegionalOperator> regionalOperatorLogin(String username, String password, HttpServletRequest request) {
        logger.debug("username:" + username + ",password:" + password);
        Result<RegionalOperator> regionalOperatorResult = regionalOperatorService.regionalOperatorLogin(username, password);
        logger.debug("regionalOperatorResult:" + regionalOperatorResult.getTotal());
        if (regionalOperatorResult != null) {
            RegionalOperator regionalOperator = (RegionalOperator) regionalOperatorResult.getData();
            request.getSession().setAttribute("loginRegionalOperator", regionalOperator);
        }
        return regionalOperatorResult;
    }
}
