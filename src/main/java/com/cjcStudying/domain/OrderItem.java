package com.cjcStudying.domain;

import java.util.Random;

public class OrderItem {
    private Integer itemid;
    private String oid;
    private String pid;
    private Integer buynum;

    public OrderItem() {
        int i = new Random().nextInt();
        int abs = Math.abs(i);
        this.itemid = abs;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "itemid=" + itemid +
                ", oid='" + oid + '\'' +
                ", pid='" + pid + '\'' +
                ", buynum=" + buynum +
                '}';
    }

    public Integer getBuynum() {
        return buynum;
    }

    public void setBuynum(Integer buynum) {
        this.buynum = buynum;
    }

    public Integer getItemid() {
        return itemid;
    }

    public void setItemid(Integer itemid) {
        this.itemid = itemid;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }
}
