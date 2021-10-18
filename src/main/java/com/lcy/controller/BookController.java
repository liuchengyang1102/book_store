package com.lcy.controller;

import com.lcy.po.Book;
import com.lcy.service.BookService;
import com.lcy.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 刘呈洋
 */
@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping("/queryBookByName")
    @ResponseBody
    public Result<Book> queryBookByName(String name,@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "15") Integer limit) {
        return bookService.queryBookByName(name,page, limit);
    }
}
