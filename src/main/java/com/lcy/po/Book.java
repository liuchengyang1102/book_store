package com.lcy.po;

import java.io.Serializable;

/**
 * @author 刘呈洋
 */
public class Book implements Serializable {
    private int id;
    private int businessId;
    private int number;
    private int count;
    private String name;
    private String author;
    private String press;
    private int impression;
    private String synopsis;
    private double price;
    private String sort1;
    private String sort2;
    private String sort3;
    private String ext;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBusinessId() {
        return businessId;
    }

    public void setBusinessId(int businessId) {
        this.businessId = businessId;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public int getImpression() {
        return impression;
    }

    public void setImpression(int impression) {
        this.impression = impression;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSort1() {
        return sort1;
    }

    public void setSort1(String sort1) {
        this.sort1 = sort1;
    }

    public String getSort2() {
        return sort2;
    }

    public void setSort2(String sort2) {
        this.sort2 = sort2;
    }

    public String getSort3() {
        return sort3;
    }

    public void setSort3(String sort3) {
        this.sort3 = sort3;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }
}
