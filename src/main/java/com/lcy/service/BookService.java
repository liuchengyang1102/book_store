package com.lcy.service;

import com.lcy.po.Book;

import java.util.List;

/**
 * @author 刘呈洋
 */
public interface BookService {
    /**
     * 查询所有的图书信息
     */
    List<Book> queryBookAll();
}
