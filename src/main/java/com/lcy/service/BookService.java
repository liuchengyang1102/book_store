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
     * 通过一级分类查询图书信息
     */
    public Result<Book> queryBookBySort1(String sort1, Integer page, Integer limit);

    /**
     * 通过二级分类查询图书信息
     */
    public Result<Book> queryBookBySort2(String sort2, Integer page, Integer limit);

    /**
     * 通过三级分类查询图书信息
     */
    public Result<Book> queryBookBySort3(String sort3, Integer page, Integer limit);

    /**
     * 商家查询该店图书信息
     */
    public Result<Book> businessQueryBook(int businessId, Integer page, Integer limit);

    /**
     * 删除图书
     */
    public void deleteBook(int id);

    /**
     * 修改图书价格
     */
    public void editPrice(int id, double price);

    /**
     * 添加图书
     */
    public void addBook(int businessId, int number, int count, String name, String author, String press, int impression,
                        String synopsis, double price, String sort1, String sort2, String sort3, String ext);
}
