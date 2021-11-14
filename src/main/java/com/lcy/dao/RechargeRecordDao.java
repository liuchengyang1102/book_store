package com.lcy.dao;

import com.lcy.po.RechargeRecord;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @author 刘呈洋
 */
public interface RechargeRecordDao {
    /**
     * 添加充值记录
     */
    public int addRechargeRecord(@Param(value = "id") int id, @Param(value = "money") int money, @Param(value = "time") String time);

    /**
     * 查询充值记录
     */
    public List<RechargeRecord> queryRechargeRecord(@Param(value = "userId") int userId);
}
