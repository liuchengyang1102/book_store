package com.lcy.controller;

import com.lcy.po.Book;
import com.lcy.service.BookService;
import com.lcy.util.Result;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

/**
 * @author 刘呈洋
 */
@Controller
public class BookController {
    private final static Logger logger = Logger.getLogger(BookController.class);
    private final String filePathDir = "D:\\JAVA\\IDEA\\java_code\\ssm_code\\book_store\\src\\main\\webapp\\images\\bookImages\\";

    @Autowired
    private BookService bookService;

    @RequestMapping("/queryBook")
    @ResponseBody
    public Result<Book> queryBook(@RequestParam(defaultValue = "") String name, String author, String press, String sort1, String sort2, String sort3,
                                  @RequestParam(defaultValue = "-1") double priceMin, @RequestParam(defaultValue = "-1") double priceMax,
                                  @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "15") Integer limit) {
        logger.debug("接口是：queryBook，入参是——" + "name:" + name + ",author:" + author + ",press:" + press + ",sort1:" + sort1 + ",sort2:" + sort2 +
                ",sort3:" + sort3 + ",priceMin:" + priceMin + ",priceMax:" + priceMax);
        Result<Book> books = null;
        if (priceMin != -1 && priceMax != -1) {
            books = bookService.queryBookByPrice(priceMin, priceMax, page, limit);
        } else if (author != null) {
            books = bookService.queryBookByAuthor(author, page, limit);
        } else if (press != null) {
            books = bookService.queryBookByPress(press, page, limit);
        } else if (sort1 != null) {
            books = bookService.queryBookBySort1(sort1, page, limit);
        } else if (sort2 != null) {
            books = bookService.queryBookBySort2(sort2, page, limit);
        } else if (sort3 != null) {
            books = bookService.queryBookBySort3(sort3, page, limit);
        } else {
            books = bookService.queryBookByName(name, page, limit);
        }
        return books;
    }

    @RequestMapping("/businessQueryBook")
    @ResponseBody
    public Result<Book> businessQueryBook(@RequestParam(defaultValue = "-1") int businessId, @RequestParam(defaultValue = "1") Integer page,
                                          @RequestParam(defaultValue = "15") Integer limit) {
        logger.debug("接口是：businessQueryBook，入参是——" + "businessId:" + businessId);
        return bookService.businessQueryBook(businessId, page, limit);
    }

    @RequestMapping("/deleteBook")
    @ResponseBody
    public void deleteBook(@RequestParam(defaultValue = "-1") int id) {
        logger.debug("接口是：deleteBook，入参是——" + "businessId:" + "id:" + id);
        bookService.deleteBook(id);
    }

    @RequestMapping("/editPrice")
    @ResponseBody
    public void editPrice(@RequestParam(defaultValue = "-1") int id, double price) {
        logger.debug("接口是：editPrice，入参是——" + "id:" + id + ",price" + price);
        bookService.editPrice(id, price);
    }

    @RequestMapping("uploadImage2")
    @ResponseBody
    public String uploadImage(@RequestParam("file") MultipartFile file) throws IOException {
        // 旧的文件名称
        String oldFileName = file.getOriginalFilename();
        //获取文件扩展名
        String extname = oldFileName.substring(file.getOriginalFilename().lastIndexOf("."));

        //防止重名
        String newFlieName = UUID.randomUUID().toString() + extname;
        //返回是整个文件的大小
        String savePath = filePathDir + newFlieName;
        File file1 = new File(savePath);
        if (!file1.exists()) {
            file1.createNewFile();
        }
        Integer n = FileCopyUtils.copy(file.getInputStream(), new FileOutputStream(new File(savePath)));
        long size = file.getSize();
        if (n != size) {
            return "文件上传失败! ";
        } else {
            return newFlieName;
        }
    }

    @RequestMapping("addBook")
    @ResponseBody
    public void addBook(int businessId, int number, int count, String name, String author, String press, int impression,
                        String synopsis, double price, String sort1, String sort2, String sort3, String ext) {
        logger.debug("接口是：addBook，入参是——" + "businessId:" + businessId + ",number:" + number + ",count:" + count + ",name:" + name + ",author:" + author
                + ",press:" + press + ",impression:" + impression + ",synopsis:" + synopsis + ",price:" + price + ",sort1:" + sort1
                + ",sort2:" + sort2 + ",sort3:" + sort3 + ",ext:" + ext);
        bookService.addBook(businessId, number, count, name, author, press, impression, synopsis, price, sort1, sort2, sort3, ext);
    }
}
