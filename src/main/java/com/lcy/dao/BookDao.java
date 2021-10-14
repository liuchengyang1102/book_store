package com.lcy.dao;

import com.lcy.po.Book;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 刘呈洋
 */
public interface BookDao {
    /**
     * 查询所有的图书信息
     */
    @Select("select * from book")
    List<Book> queryBookAll();
}
