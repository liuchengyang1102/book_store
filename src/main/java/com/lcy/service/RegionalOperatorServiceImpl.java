package com.lcy.service;

import com.lcy.dao.RegionalOperatorDao;
import com.lcy.po.RegionalOperator;
import com.lcy.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 刘呈洋
 */
@Service
public class RegionalOperatorServiceImpl implements RegionalOperatorService {

    @Autowired
    private RegionalOperatorDao regionalOperatorDao;

    @Override
    public Result<RegionalOperator> regionalOperatorLogin(String userName, String password) {
        RegionalOperator regionalOperator = regionalOperatorDao.regionalOperatorLogin(userName, password);
        return Result.bulid2(0, 1L, regionalOperator);
    }
}
