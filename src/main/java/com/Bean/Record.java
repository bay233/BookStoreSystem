package com.Bean;

import java.io.Serializable;
import java.sql.Timestamp;

public class Record implements Serializable {
    private Long rId;
    private Long bId;
    private Integer num;
    private Timestamp dateTime;


    public void setrId(Long rId) {
        this.rId = rId;
    }

    public void setbId(Long bId) {
        this.bId = bId;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }

    public Long getrId() {
        return rId;
    }

    public Long getbId() {
        return bId;
    }

    public Integer getNum() {
        return num;
    }

    public Timestamp getDateTime() {
        return dateTime;
    }

    @Override
    public String toString() {
        return "Record{" +
                "rId=" + rId +
                ", bId=" + bId +
                ", num=" + num +
                ", dateTime=" + dateTime +
                '}';
    }
}
