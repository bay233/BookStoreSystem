package com.Bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "商品", description="商品实体信息")
public class Book implements Serializable {
    @ApiModelProperty(value="商品编号", dataType = "java.lang.Long")
    private Long bId;
    @ApiModelProperty(value="商品名称", dataType = "java.lang.String")
    private String bName;
    @ApiModelProperty(value="商品详细说明", dataType = "java.lang.String")
    private String explain;
    @ApiModelProperty(value="商品图片地址", dataType = "java.lang.String")
    private String picture;
    @ApiModelProperty(value="商品类别", dataType = "java.lang.String")
    private String sort;
    @ApiModelProperty(value="商品默认价格", dataType = "java.lang.Double")
    private Double price = 0.0;
    @ApiModelProperty(value="商品库存数", dataType = "java.lang.Integer")
    private Integer num = 0;

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
