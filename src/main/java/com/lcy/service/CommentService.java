package com.lcy.service;

import com.lcy.po.Comment;
import com.lcy.util.Result;

/**
 * @author 刘呈洋
 */
public interface CommentService {

    /**
     * 用户添加订单评论
     *
     * @param userId
     * @param orderId
     * @param level
     * @param content
     */
    public void addComment(int userId, int orderId, int level, String content);

    /**
     * 商家查看评论
     */
    public Result<Comment> queryComment(int businessId, Integer page, Integer limit);
}
