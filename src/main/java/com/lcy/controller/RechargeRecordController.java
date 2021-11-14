package com.lcy.controller;

import com.lcy.po.RechargeRecord;
import com.lcy.service.RechargeRecordService;
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
public class RechargeRecordController {
    private final static Log logger = LogFactory.getLog(RechargeRecordController.class);

    @Autowired
    private RechargeRecordService rechargeRecordService;

    @RequestMapping("queryRechargeRecord")
    @ResponseBody
    public Result<RechargeRecord> queryRechargeRecord(@RequestParam(defaultValue = "-1") int userId, @RequestParam(defaultValue = "1") Integer page,
                                                      @RequestParam(defaultValue = "15") Integer limit) {
        logger.debug("userId:" + userId);
        return rechargeRecordService.queryRechargeRecord(userId, page, limit);
    }
}
