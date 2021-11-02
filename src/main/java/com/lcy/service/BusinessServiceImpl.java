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

    @Override
    public void addBusiness(String userName, String password, String name, String address, String type,
                            double registeredCapital, String logPicture) {
        businessDao.addBusiness(userName, password, name, address, type, registeredCapital, logPicture);
    }
}
