package com.cjcStudying.domain;

import java.io.UnsupportedEncodingException;
import java.util.Random;

public class Category {
    private int cid;
    private String cname;

    public Category() {
        int i = new Random().nextInt();
        int abs = Math.abs(i);
        this.cid = abs;
    }

    @Override
    public String toString() {
        return "Category{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                '}';
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        String now = cname;
        try {
            now = new String(cname.getBytes("iso-8859-1"),"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
//        System.out.println(now);
        this.cname = now;
    }
}
