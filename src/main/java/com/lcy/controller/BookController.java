package com.lcy.controller;

import com.lcy.po.Book;
import com.lcy.service.BookService;
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
public class BookController {
    private final static Log logger = LogFactory.getLog(BookController.class);

    @Autowired
    private BookService bookService;

    @RequestMapping("/queryBook")
    @ResponseBody
    public Result<Book> queryBook(@RequestParam(defaultValue = "") String name, String author, String press,
                                  @RequestParam(defaultValue = "-1") double priceMin, @RequestParam(defaultValue = "-1") double priceMax,
                                  @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "15") Integer limit) {
        logger.debug("name:" + name + ",author:" + author + ",press:" + press + ",priceMin:" + priceMin + ",priceMax:" + priceMax);
        Result<Book> books = null;
        if (priceMin != -1 && priceMax != -1) {
            books = bookService.queryBookByPrice(priceMin, priceMax, page, limit);
        } else if (author != null) {
            books = bookService.queryBookByAuthor(author, page, limit);
        } else if (press != null) {
            books = bookService.queryBookByPress(press, page, limit);
        } else {
            books = bookService.queryBookByName(name, page, limit);
        }
        return books;
    }
}
