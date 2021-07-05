package com.cjcStudying.domain;

import java.util.Random;

public class ShoppingItems {
    private Product product;
    private Integer snum;
    private Integer itemid;
    private String pid;

    public ShoppingItems() {
        int i = new Random().nextInt();
        int abs = Math.abs(i);
        this.itemid = abs;
    }

    @Override
    public String toString() {
        return "ShoppingItems{" +
                "product=" + product +
                ", snum=" + snum +
                ", itemid=" + itemid +
                ", pid='" + pid + '\'' +
                '}';
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getSnum() {
        return snum;
    }

    public void setSnum(Integer snum) {
        this.snum = snum;
    }

    public Integer getItemid() {
        return itemid;
    }

    public void setItemid(Integer itemid) {
        this.itemid = itemid;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }
}
