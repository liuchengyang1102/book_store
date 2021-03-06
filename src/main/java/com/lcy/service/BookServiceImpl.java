package com.lcy.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lcy.dao.BookDao;
import com.lcy.po.Book;
import com.lcy.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 刘呈洋
 */
@Service("BookService")
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public Result<Book> queryBookByName(String name, Integer page, Integer limit) {
        //传入参数，当前页、每页条数
        PageHelper.startPage(page, limit);
        List<Book> books = bookDao.queryBookByName(name);
        //通过包装获取分页的其它值信息
        PageInfo<Book> pageInfo = new PageInfo<>(books);
        return Result.bulid(0, pageInfo.getTotal(), books);
    }

    @Override
    public Result<Book> queryBookByAuthor(String author, Integer page, Integer limit) {
        //传入参数，当前页、每页条数
        PageHelper.startPage(page, limit);
        List<Book> books = bookDao.queryBookByAuthor(author);
        //通过包装获取分页的其它值信息
        PageInfo<Book> pageInfo = new PageInfo<>(books);
        return Result.bulid(0, pageInfo.getTotal(), books);
    }

    @Override
    public Result<Book> queryBookByPress(String press, Integer page, Integer limit) {
        //传入参数，当前页、每页条数
        PageHelper.startPage(page, limit);
        List<Book> books = bookDao.queryBookByPress(press);
        //通过包装获取分页的其它值信息
        PageInfo<Book> pageInfo = new PageInfo<>(books);
        return Result.bulid(0, pageInfo.getTotal(), books);
    }

    @Override
    public Result<Book> queryBookByPrice(double priceMin, double priceMax, Integer page, Integer limit) {
        //传入参数，当前页、每页条数
        PageHelper.startPage(page, limit);
        List<Book> books = bookDao.queryBookByPrice(priceMin, priceMax);
        //通过包装获取分页的其它值信息
        PageInfo<Book> pageInfo = new PageInfo<>(books);
        return Result.bulid(0, pageInfo.getTotal(), books);
    }

    @Override
    public Result<Book> queryBookBySort1(String sort1, Integer page, Integer limit) {
        //传入参数，当前页、每页条数
        PageHelper.startPage(page, limit);
        List<Book> books = bookDao.queryBookBySort1(sort1);
        //通过包装获取分页的其它值信息
        PageInfo<Book> pageInfo = new PageInfo<>(books);
        return Result.bulid(0, pageInfo.getTotal(), books);
    }

    @Override
    public Result<Book> queryBookBySort2(String sort2, Integer page, Integer limit) {
        //传入参数，当前页、每页条数
        PageHelper.startPage(page, limit);
        List<Book> books = bookDao.queryBookBySort2(sort2);
        //通过包装获取分页的其它值信息
        PageInfo<Book> pageInfo = new PageInfo<>(books);
        return Result.bulid(0, pageInfo.getTotal(), books);
    }

    @Override
    public Result<Book> queryBookBySort3(String sort3, Integer page, Integer limit) {
        //传入参数，当前页、每页条数
        PageHelper.startPage(page, limit);
        List<Book> books = bookDao.queryBookBySort3(sort3);
        //通过包装获取分页的其它值信息
        PageInfo<Book> pageInfo = new PageInfo<>(books);
        return Result.bulid(0, pageInfo.getTotal(), books);
    }

    @Override
    public Result<Book> businessQueryBook(int businessId, Integer page, Integer limit) {
        //传入参数，当前页、每页条数
        PageHelper.startPage(page, limit);
        List<Book> books = bookDao.businessQueryBook(businessId);
        //通过包装获取分页的其它值信息
        PageInfo<Book> pageInfo = new PageInfo<>(books);
        return Result.bulid(0, pageInfo.getTotal(), books);
    }

    @Override
    public void deleteBook(int id) {
        bookDao.deleteBook(id);
    }

    @Override
    public void editPrice(int id, double price) {
        bookDao.editPrice(id, price);
    }

    @Override
    public void addBook(int businessId, int number, int count, String name, String author, String press, int impression,
                        String synopsis, double price, String sort1, String sort2, String sort3, String ext) {
        bookDao.addBook(businessId, number, count, name, author, press, impression, synopsis, price, sort1, sort2, sort3, ext);
    }
}
