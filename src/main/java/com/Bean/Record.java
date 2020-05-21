package com.Bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.sql.Timestamp;

@ApiModel(value = "库存更改记录", description="库存记录实体信息")
public class Record implements Serializable {
    @ApiModelProperty(value="记录编号", dataType = "java.lang.Long")
    private Long rId;
    @ApiModelProperty(value="商品编号", dataType = "java.lang.Long")
    private Long bId;
    @ApiModelProperty(value="修改数量", dataType = "java.lang.Integer")
    private Integer num;
    @ApiModelProperty(value="修改时间", dataType = "java.sql.Timestamp")
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
