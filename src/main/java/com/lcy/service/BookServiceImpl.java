package com.lcy.service;

import com.lcy.dao.BookDao;
import com.lcy.po.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("BookService")
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public List<Book> queryBookAll() {
        System.out.println("获取图书类型的记录为：" + bookDao.queryBookAll().size());
        System.out.println("查询所有的图书信息");
        return null;
    }
}
