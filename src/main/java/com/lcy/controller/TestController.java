package com.lcy.controller;

import com.lcy.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 刘呈洋
 */
@Controller
public class TestController {

    @Autowired
    private BookService bookService;

    @RequestMapping("/test")
    public String testSpringMvc() {
//        bookService.queryBookAll();
        System.out.println("测试spring mvc内容");
        return "/test";
    }
}
