package com.Bean;

import java.io.Serializable;
import java.sql.Timestamp;

public class Order implements Serializable {
    private Long oId;
    private Long uId;
    private Long bId;
    private Integer num;
    private String adder;
    private Long phone;
    private Timestamp dateTime;
    private Integer state;

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

    public void setAdder(String adder) {
        this.adder = adder;
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

    public String getAdder() {
        return adder;
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
                ", adder='" + adder + '\'' +
                ", phone=" + phone +
                ", dateTime=" + dateTime +
                ", state=" + state +
                '}';
    }
}
