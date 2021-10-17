package com.lcy.service;

import com.lcy.po.Book;
import com.lcy.util.Result;

/**
 * @author 刘呈洋
 */
public interface BookService {
    /**
     * 查询图书信息
     */
    public Result<Book> queryBook(Integer page, Integer limit);
}
