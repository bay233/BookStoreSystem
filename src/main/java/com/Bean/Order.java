package com.Bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.sql.Timestamp;

@ApiModel(value = "订单", description="订单实体信息")
public class Order implements Serializable {

    @ApiModelProperty(value="订单编号", dataType = "java.lang.Long")
    private Long oId;
    @ApiModelProperty(value="用户编号", dataType = "java.lang.Long")
    private Long uId;
    @ApiModelProperty(value="商品编号", dataType = "java.lang.Long")
    private Long bId;
    @ApiModelProperty(value="购买数量", dataType = "java.lang.Integer")
    private Integer num;
    @ApiModelProperty(value="收货地址", dataType = "java.lang.String")
    private String addr;
    @ApiModelProperty(value="联系电话", dataType = "java.lang.Long")
    private Long phone;
    @ApiModelProperty(value="订单状态", dataType = "java.lang.Integer")
    private Integer state;
    @ApiModelProperty(value="购买时间", dataType = "java.sql.Timestamp")
    private Timestamp dateTime;


    public void setoId(Long oId) {
        this.oId = oId;
    }

    public void setuId(Long uId) {
        this.uId = uId;
    }

    public void setbId(Long bId) {
        this.bId = bId;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Long getoId() {
        return oId;
    }

    public Long getuId() {
        return uId;
    }

    public Long getbId() {
        return bId;
    }

    public Integer getNum() {
        return num;
    }

    public String getAddr() {
        return addr;
    }

    public Long getPhone() {
        return phone;
    }

    public Timestamp getDateTime() {
        return dateTime;
    }

    public Integer getState() {
        return state;
    }

    @Override
    public String toString() {
        return "Order{" +
                "oId=" + oId +
                ", uId=" + uId +
                ", bId=" + bId +
                ", num=" + num +
                ", addr='" + addr + '\'' +
                ", phone=" + phone +
                ", dateTime=" + dateTime +
                ", state=" + state +
                '}';
    }
}
