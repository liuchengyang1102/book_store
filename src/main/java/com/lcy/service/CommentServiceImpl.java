package com.lcy.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lcy.dao.CommentDao;
import com.lcy.dao.OrderDao;
import com.lcy.po.Comment;
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

    @Override
    public Result<Comment> queryComment(int businessId, Integer page, Integer limit) {
        //传入参数，当前页、每页条数
        PageHelper.startPage(page, limit);
        List<Comment> comments = commentDao.queryComment(businessId);
        //通过包装获取分页的其它值信息
        PageInfo<Comment> pageInfo = new PageInfo<>(comments);
        return Result.bulid(0, pageInfo.getTotal(), comments);
    }
}
