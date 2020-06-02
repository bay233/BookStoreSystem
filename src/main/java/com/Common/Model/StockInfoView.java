package com.Common.Model;

import java.io.Serializable;
import java.sql.Timestamp;

public class StockInfoView implements Serializable {

    private Long bId;
    private String bName;
    private Integer num;
    private Timestamp dateTime;


    public void setbId(Long bId) {
        this.bId = bId;
    }

    public void setbName(String bName) {
        this.bName = bName;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }

    public Long getbId() {
        return bId;
    }

    public String getbName() {
        return bName;
    }

    public Integer getNum() {
        return num;
    }

    public Timestamp getDateTime() {
        return dateTime;
    }
}
