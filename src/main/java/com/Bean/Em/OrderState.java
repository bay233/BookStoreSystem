package com.Bean.Em;


public enum OrderState {
    NEW_ORDER(0, "待支付"),
    PAID_ORDER(1, "已支付"),
    SHIPPED_ORDER(2, "已发货"),
    FINISHED_ORDER(3, "已完结"),
    REFUND_ORDER(4, "退款中"),
    CANCEL_ORDER(5, "已退款"),
    DELETE_ORDER(-1, "移除");

    private final Integer code;
    private final String value;

    OrderState(Integer code, String value) {
        this.code = code;
        this.value = value;
    }

    public Integer getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }
}
