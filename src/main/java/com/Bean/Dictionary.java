package com.Bean;

import java.io.Serializable;

public class Dictionary implements Serializable {
    private String tableName;
    private String colName;
    private Integer seq;
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
