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
    public Result<Book> queryBook(Integer page, Integer limit) {
        //传入参数，当前页、每页条数
        PageHelper.startPage(page, limit);
        List<Book> books = bookDao.queryBook();
        //通过包装获取分页的其它值信息
        PageInfo<Book> pageInfo = new PageInfo<>(books);
        return Result.bulid(pageInfo.getTotal(), books);
    }
}
