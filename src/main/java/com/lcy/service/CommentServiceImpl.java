package com.lcy.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lcy.dao.BusinessDao;
import com.lcy.dao.CommentDao;
import com.lcy.dao.OrderDao;
import com.lcy.dao.UserDao;
import com.lcy.po.Order;
import com.lcy.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 刘呈洋
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;
    @Autowired
    private OrderDao orderDao;

    @Override
    public void addComment(int userId, int businessId, int orderId, int level, String content) {
        commentDao.addComment(userId, businessId, orderId, level, content);
        orderDao.comment(orderId);
    }
}
