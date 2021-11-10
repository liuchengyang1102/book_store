package com.lcy.service;

/**
 * @author 刘呈洋
 */
public interface CommentService {

    /**
     * 用户添加订单评论
     *
     * @param userId
     * @param businessId
     * @param orderId
     * @param level
     * @param content
     */
    public void addComment(int userId, int businessId, int orderId, int level, String content);
}
