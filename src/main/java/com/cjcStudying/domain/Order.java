package com.cjcStudying.domain;

import java.util.Date;
import java.util.UUID;

public class Order {
    private String oid;
    private Double money;
    private String recipients;
    private String tel;
    private String address;
    private Integer state;
    private Date orderTime;
    private String uid;
    //还没做
//    private Product product;

    public Order() {
        String s = UUID.randomUUID().toString().replace("-", "");
        this.oid = s;
        Date date = new Date();
        this.orderTime = date;
        this.state = 1;
    }

    @Override
    public String toString() {
        return "Order{" +
                "oid='" + oid + '\'' +
                ", money=" + money +
                ", recipients='" + recipients + '\'' +
                ", tel='" + tel + '\'' +
                ", address='" + address + '\'' +
                ", state=" + state +
                ", orderTime=" + orderTime +
                ", uid='" + uid + '\'' +
                '}';
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public String getRecipients() {
        return recipients;
    }

    public void setRecipients(String recipients) {
        this.recipients = recipients;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
