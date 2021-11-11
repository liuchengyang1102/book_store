package com.lcy.po;

import java.io.Serializable;

/**
 * @author 刘呈洋
 */
public class Business implements Serializable {
    private int id;
    private String userName;
    private String password;
    private String name;
    private String address;
    private String type;
    private double registeredCapital;
    private String logPicture;
    private double balance;
    private String state;
    private String ext;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getRegisteredCapital() {
        return registeredCapital;
    }

    public void setRegisteredCapital(double registeredCapital) {
        this.registeredCapital = registeredCapital;
    }

    public String getLogPicture() {
        return logPicture;
    }

    public void setLogPicture(String logPicture) {
        this.logPicture = logPicture;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }
}
