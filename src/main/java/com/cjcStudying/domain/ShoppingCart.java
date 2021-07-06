package com.cjcStudying.domain;

import java.util.List;
import java.util.Random;

public class ShoppingCart {
    private List<ShoppingItems> shoppingItems;
    private Integer sid;
    private Integer uid;

    public ShoppingCart() {
        int i = new Random().nextInt();
        int abs = Math.abs(i);
        this.sid = abs;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "shoppingItems=" + shoppingItems +
                ", sid=" + sid +
                ", uid=" + uid +
                '}';
    }

    public List<ShoppingItems> getShoppingItems() {
        return shoppingItems;
    }

    public void setShoppingItems(List<ShoppingItems> shoppingItems) {
        this.shoppingItems = shoppingItems;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }
}
