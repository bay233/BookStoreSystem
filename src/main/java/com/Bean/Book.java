package com.Bean;

import java.io.Serializable;

public class Book implements Serializable {
    private Long bId;
    private String bName;
    private String explain;
    private String picture;
    private String sort;
    private Double price;
    private Integer num;

    public void setbId(Long bId) {
        this.bId = bId;
    }

    public void setbName(String bName) {
        this.bName = bName;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Long getbId() {
        return bId;
    }

    public String getbName() {
        return bName;
    }

    public String getExplain() {
        return explain;
    }

    public String getPicture() {
        return picture;
    }

    public String getSort() {
        return sort;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getNum() {
        return num;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bId=" + bId +
                ", bName='" + bName + '\'' +
                ", explain='" + explain + '\'' +
                ", picture='" + picture + '\'' +
                ", sort='" + sort + '\'' +
                ", price=" + price +
                ", num=" + num +
                '}';
    }
}
