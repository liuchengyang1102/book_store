package com.lcy.dao;

import com.lcy.po.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 刘呈洋
 */
public interface BookDao {
    /**
     * 通过书名查询图书信息
     */
    List<Book> queryBookByName(@Param(value = "name") String name);

    /**
     * 通过作者查询图书信息
     */
    List<Book> queryBookByAuthor(@Param(value = "author") String author);

    /**
     * 通过出版社查询图书信息
     */
    List<Book> queryBookByPress(@Param(value = "press") String press);
}
