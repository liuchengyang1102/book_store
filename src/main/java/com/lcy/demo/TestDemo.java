package com.lcy.demo;

import com.lcy.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 刘呈洋
 */
public class TestDemo {

    @Test
    public void testSpring() {
        //获取spring容器
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        //获取bean
        BookService bookService = (BookService) context.getBean("BookService");
//        bookService.queryBookAll();
    }
}
