package com.Common.Model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class TotalRecordView implements Serializable {

    private Long total;
    private List<Map<String, String>> groupYear;
    private List<Map<String, String>> groupMath;
    private List<Map<String, String>> groupDay;

    public void setTotal(Long total) {
        this.total = total;
    }

    public void setGroupYear(List<Map<String, String>> groupYear) {
        this.groupYear = groupYear;
    }

    public void setGroupMath(List<Map<String, String>> groupMath) {
        this.groupMath = groupMath;
    }

    public void setGroupDay(List<Map<String, String>> groupDay) {
        this.groupDay = groupDay;
    }

    public Long getTotal() {
        return total;
    }

    public List<Map<String, String>> getGroupYear() {
        return groupYear;
    }

    public List<Map<String, String>> getGroupMath() {
        return groupMath;
    }

    public List<Map<String, String>> getGroupDay() {
        return groupDay;
    }
}
