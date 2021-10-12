package com.lcy.dao;

import com.lcy.po.Book;

import java.util.List;

/**
 * @author 刘呈洋
 */
public interface BookDao {
    /**
     * 查询所有的图书信息
     */
    List<Book> queryBookAll();
}
