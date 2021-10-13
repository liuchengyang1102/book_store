package com.lcy.service;

import com.lcy.po.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("BookService")
public class BookServiceImpl implements BookService {
    @Override
    public List<Book> queryBookAll() {
        System.out.println("查询所有的图书信息");
        return null;
    }
}
