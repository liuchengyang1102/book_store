package com.lcy.controller;

import com.lcy.po.Comment;
import com.lcy.service.CommentService;
import com.lcy.util.Result;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 刘呈洋
 */
@Controller
public class CommentController {
    private final static Log logger = LogFactory.getLog(CommentController.class);

    @Autowired
    private CommentService commentService;

    @RequestMapping("addComment")
    @ResponseBody
    public void addComment(int userId, int businessId, int orderId, int level, String content) {
        logger.debug("userId:" + userId + ",businessId:" + businessId + ",orderId:" + orderId + ",level:" + level + ",content:" + content);
        commentService.addComment(userId, businessId, orderId, level, content);
    }

    @RequestMapping("queryComment")
    @ResponseBody
    public Result<Comment> queryComment(@RequestParam(defaultValue = "-1") int businessId, @RequestParam(defaultValue = "1") Integer page,
                                        @RequestParam(defaultValue = "15") Integer limit) {
        logger.debug("businessId:" + businessId);
        Result<Comment> comments = null;
        comments = commentService.queryComment(businessId, page, limit);
        return comments;
    }
}
