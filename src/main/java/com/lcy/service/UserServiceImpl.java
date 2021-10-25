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
        User user = userDao.userLogin(username, password);
        return Result.bulid2(0, 1L, user);
    }
}
