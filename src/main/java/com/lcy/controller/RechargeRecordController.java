package com.lcy.controller;

import com.lcy.po.RechargeRecord;
import com.lcy.service.RechargeRecordService;
import com.lcy.util.Result;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 刘呈洋
 */
@Controller
public class RechargeRecordController {
    private final static Logger logger = Logger.getLogger(RechargeRecordController.class);

    @Autowired
    private RechargeRecordService rechargeRecordService;

    @RequestMapping("queryRechargeRecord")
    @ResponseBody
    public Result<RechargeRecord> queryRechargeRecord(@RequestParam(defaultValue = "-1") int userId, @RequestParam(defaultValue = "1") Integer page,
                                                      @RequestParam(defaultValue = "15") Integer limit) {
        logger.debug("接口是：queryRechargeRecord，入参是——" + "userId:" + userId);
        return rechargeRecordService.queryRechargeRecord(userId, page, limit);
    }
}
