package com.cjcStudying.domain;

public class SearchCondition {
    private String pid;
    private Integer cid;
    private String pname;
    private Double minprice;
    private Double maxprice;

    public SearchCondition() {
    }

    @Override
    public String toString() {
        return "SearchCondition{" +
                "pid='" + pid + '\'' +
                ", cid=" + cid +
                ", pname='" + pname + '\'' +
                ", minprice=" + minprice +
                ", maxprice=" + maxprice +
                '}';
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Double getMinprice() {
        return minprice;
    }

    public void setMinprice(Double minprice) {
        this.minprice = minprice;
    }

    public Double getMaxprice() {
        return maxprice;
    }

    public void setMaxprice(Double maxprice) {
        this.maxprice = maxprice;
    }
}
