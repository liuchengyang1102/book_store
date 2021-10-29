package com.lcy.service;

import com.lcy.dao.BusinessDao;
import com.lcy.po.Business;
import com.lcy.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 刘呈洋
 */
@Service
public class BusinessServiceImpl implements BusinessService {

    @Autowired
    private BusinessDao businessDao;

    @Override
    public Result<Business> businessLogin(String username, String password) {
        Business business = businessDao.businessLogin(username, password);
        return Result.bulid2(0, 1L, business);
    }
}
