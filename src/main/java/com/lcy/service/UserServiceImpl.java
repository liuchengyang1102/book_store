package com.lcy.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lcy.dao.RechargeRecordDao;
import com.lcy.dao.UserDao;
import com.lcy.po.User;
import com.lcy.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author 刘呈洋
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private RechargeRecordDao rechargeRecordDao;

    @Override
    public Result<User> userLogin(String username, String password) {
        User user = userDao.userLogin(username, password);
        return Result.bulid2(0, 1L, user);
    }

    @Override
    public int addUser(String username, String password, String name) {
        return userDao.addUser(username, password, name);
    }

    @Override
    public Result<User> queryBalance(int id, Integer page, Integer limit) {
        //传入参数，当前页、每页条数
        PageHelper.startPage(page, limit);
        List<User> users = userDao.queryBalance(id);
        //通过包装获取分页的其它值信息
        PageInfo<User> pageInfo = new PageInfo<>(users);
        return Result.bulid(0, pageInfo.getTotal(), users);
    }

    @Override
    public void recharge(int id, int money) {
        userDao.recharge(id, money);
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        rechargeRecordDao.addRechargeRecord(id, money, dateFormat.format(date));
    }
}
