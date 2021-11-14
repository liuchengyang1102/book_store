package com.lcy.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lcy.dao.BookDao;
import com.lcy.dao.RechargeRecordDao;
import com.lcy.po.Book;
import com.lcy.po.RechargeRecord;
import com.lcy.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 刘呈洋
 */
@Service
public class RechargeRecordServiceImpl implements RechargeRecordService {

    @Autowired
    private RechargeRecordDao rechargeRecordDao;

    @Override
    public Result<RechargeRecord> queryRechargeRecord(int userId, Integer page, Integer limit) {
        //传入参数，当前页、每页条数
        PageHelper.startPage(page, limit);
        List<RechargeRecord> rechargeRecords = rechargeRecordDao.queryRechargeRecord(userId);
        //通过包装获取分页的其它值信息
        PageInfo<RechargeRecord> pageInfo = new PageInfo<>(rechargeRecords);
        return Result.bulid(0, pageInfo.getTotal(), rechargeRecords);
    }
}
