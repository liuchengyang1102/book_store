package com.lcy.service;

import com.lcy.po.RechargeRecord;
import com.lcy.util.Result;

/**
 * @author 刘呈洋
 */
public interface RechargeRecordService {
    /**
     * 查询充值记录
     */
    public Result<RechargeRecord> queryRechargeRecord(int userId, Integer page, Integer limit);
}
