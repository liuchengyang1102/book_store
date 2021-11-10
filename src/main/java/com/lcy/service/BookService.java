package com.lcy.service;

import com.lcy.po.Book;
import com.lcy.util.Result;
import org.springframework.stereotype.Service;

/**
 * @author 刘呈洋
 */
public interface BookService {
    /**
     * 通过书名查询图书信息
     */
    public Result<Book> queryBookByName(String name, Integer page, Integer limit);

    /**
     * 通过作者查询图书信息
     */
    public Result<Book> queryBookByAuthor(String author, Integer page, Integer limit);

    /**
     * 通过出版社查询图书信息
     */
    public Result<Book> queryBookByPress(String press, Integer page, Integer limit);

    /**
     * 通过价格范围查询图书信息
     */
    public Result<Book> queryBookByPrice(double priceMin, double priceMax, Integer page, Integer limit);

    /**
     * 商家查询该店图书信息
     */
    public Result<Book> businessQueryBook(int businessId, Integer page, Integer limit);
}
