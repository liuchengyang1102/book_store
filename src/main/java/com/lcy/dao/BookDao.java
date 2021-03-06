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

    /**
     * 通过出版社查询图书信息
     */
    List<Book> queryBookByPrice(@Param(value = "priceMin") double priceMin, @Param(value = "priceMax") double priceMax);

    /**
     * 通过一级分类查询图书信息
     */
    List<Book> queryBookBySort1(@Param(value = "sort1") String sort1);

    /**
     * 通过二级分类查询图书信息
     */
    List<Book> queryBookBySort2(@Param(value = "sort2") String sort2);

    /**
     * 通过三级分类查询图书信息
     */
    List<Book> queryBookBySort3(@Param(value = "sort3") String sort3);

    /**
     * 通过图书id查询商家id
     */
    int queryBusinessId(@Param(value = "id") int id);

    /**
     * 商家查询该店图书信息
     */
    List<Book> businessQueryBook(@Param(value = "businessId") int businessId);

    /**
     * 商家发货
     */
    int sendGoods(@Param(value = "id") int id);

    /**
     * 删除图书
     */
    public void deleteBook(@Param(value = "id") int id);

    /**
     * 修改图书价格
     */
    public void editPrice(@Param(value = "id") int id, @Param(value = "price") double price);

    /**
     * 添加图书
     */
    public void addBook(int businessId, int number, int count, String name, String author, String press, int impression,
                        String synopsis, double price, String sort1, String sort2, String sort3, String ext);
}
