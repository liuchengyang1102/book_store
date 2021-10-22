package com.lcy.service;

import com.github.pagehelper.PageInfo;
import com.lcy.dao.UserDao;
import com.lcy.po.User;
import com.lcy.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 刘呈洋
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public Result<User> userLogin(String username, String password) {
        List<User> user = userDao.userLogin(username, password);
        PageInfo<User> pageInfo = new PageInfo<>(user);
        return Result.bulid(0, pageInfo.getTotal(), user);
    }
}
