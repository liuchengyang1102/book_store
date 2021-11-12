package com.lcy.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lcy.dao.BusinessDao;
import com.lcy.po.Book;
import com.lcy.po.Business;
import com.lcy.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public int addBusiness(String userName, String password, String name, String address, String type,
                           double registeredCapital, String logPicture) {
        return businessDao.addBusiness(userName, password, name, address, type, registeredCapital, logPicture);
    }

    @Override
    public Result<Business> queryBusiness(String area, Integer page, Integer limit) {
        //传入参数，当前页、每页条数
        PageHelper.startPage(page, limit);
        List<Business> businesses = businessDao.queryBusiness(area);
        //通过包装获取分页的其它值信息
        PageInfo<Business> pageInfo = new PageInfo<>(businesses);
        return Result.bulid(0, pageInfo.getTotal(), businesses);
    }

    @Override
    public void pass(int id) {
        businessDao.pass(id);
    }

    @Override
    public void failed(int id) {
        businessDao.failed(id);
    }

    @Override
    public Result<Business> queryState(int id, Integer page, Integer limit) {
        //传入参数，当前页、每页条数
        PageHelper.startPage(page, limit);
        List<Business> businesses = businessDao.queryState(id);
        //通过包装获取分页的其它值信息
        PageInfo<Business> pageInfo = new PageInfo<>(businesses);
        return Result.bulid(0, pageInfo.getTotal(), businesses);
    }

    @Override
    public int businessManage(String state, int id) {
        return businessDao.businessManage(state, id);
    }
}
