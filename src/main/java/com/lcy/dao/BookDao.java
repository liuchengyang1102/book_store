package com.lcy.dao;

import com.lcy.po.Book;

import java.util.List;

/**
 * @author 刘呈洋
 */
public interface BookDao {
    /**
     * 通过书名查询图书信息
     */
    List<Book> queryBookByName(String name);
}
