package com.Bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "字典", description="字典实体信息")
public class Dictionary implements Serializable {
    @ApiModelProperty(value="表名", dataType = "java.lang.String")
    private String tableName;
    @ApiModelProperty(value="列名", dataType = "java.lang.String")
    private String colName;
    @ApiModelProperty(value="序列号", dataType = "java.lang.Integer")
    private Integer seq;
    @ApiModelProperty(value="对应值", dataType = "java.lang.String")
    private String value;

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public void setColName(String colName) {
        this.colName = colName;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getTableName() {
        return tableName;
    }

    public String getColName() {
        return colName;
    }

    public Integer getSeq() {
        return seq;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Dictionary{" +
                "tableName='" + tableName + '\'' +
                ", colName='" + colName + '\'' +
                ", seq=" + seq +
                ", value='" + value + '\'' +
                '}';
    }
}
