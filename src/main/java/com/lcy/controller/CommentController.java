package com.lcy.controller;

import com.lcy.po.Comment;
import com.lcy.service.CommentService;
import com.lcy.util.Result;
import org.apache.log4j.Logger;
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
    private final static Logger logger = Logger.getLogger(CommentController.class);

    @Autowired
    private CommentService commentService;

    @RequestMapping("addComment")
    @ResponseBody
    public void addComment(int userId, int orderId, @RequestParam(defaultValue = "5") int level, String content) {
        logger.debug("接口是：addComment，入参是——" + "userId:" + userId + ",orderId:" + orderId + ",level:" + level + ",content:" + content);
        commentService.addComment(userId, orderId, level, content);
    }

    @RequestMapping("queryComment")
    @ResponseBody
    public Result<Comment> queryComment(@RequestParam(defaultValue = "-1") int businessId, @RequestParam(defaultValue = "1") Integer page,
                                        @RequestParam(defaultValue = "15") Integer limit) {
        logger.debug("接口是：queryComment，入参是——" + "businessId:" + businessId);
        Result<Comment> comments = null;
        comments = commentService.queryComment(businessId, page, limit);
        return comments;
    }
}
