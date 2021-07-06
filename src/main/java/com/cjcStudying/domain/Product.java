package com.cjcStudying.domain;

import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

public class Product {
    private String pid;
    private String pname;
    private double eStorePrice;
    private double markPrice;
    private int pNum;
    private int cid;
    private String imgUrl;
    private String desc;
    private MultipartFile imgurl;
    private Category category;

    public Product() {
        String s = UUID.randomUUID().toString().replace("-", "");
        this.pid = s;
    }

    @Override
    public String toString() {
        return "Product{" +
                "pid='" + pid + '\'' +
                ", pname='" + pname + '\'' +
                ", eStorePrice=" + eStorePrice +
                ", markPrice=" + markPrice +
                ", pNum=" + pNum +
                ", cid=" + cid +
                ", imgUrl='" + imgUrl + '\'' +
                ", desc='" + desc + '\'' +
                ", imgurl=" + imgurl +
                ", category=" + category +
                '}';
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public MultipartFile getImgurl() {
        return imgurl;
    }

    public void setImgurl(MultipartFile imgurl) {
        this.imgurl = imgurl;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
//        String name = NameUtils.encodingName(pname);
//        this.pname = name;
        this.pname = pname;
    }

    public double geteStorePrice() {
        return eStorePrice;
    }

    public void seteStorePrice(double eStorePrice) {
        this.eStorePrice = eStorePrice;
    }

    public double getMarkPrice() {
        return markPrice;
    }

    public void setMarkPrice(double markPrice) {
        this.markPrice = markPrice;
    }

    public int getpNum() {
        return pNum;
    }

    public void setpNum(int pNum) {
        this.pNum = pNum;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
//        String name = NameUtils.encodingName(desc);
//        this.desc = name;
        this.desc = desc;
    }
}
