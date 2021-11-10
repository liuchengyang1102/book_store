package com.lcy.dao;

import org.apache.ibatis.annotations.Param;

/**
 * @author 刘呈洋
 */
public interface CommentDao {
    /**
     * 用户添加订单评论
     *
     * @param userId
     * @param businessId
     * @param orderId
     * @param level
     * @param content
     */
    void addComment(@Param(value = "userId") int userId, @Param(value = "businessId") int businessId,
                    @Param(value = "orderId") int orderId, @Param(value = "level") int level, @Param(value = "content") String content);
}
