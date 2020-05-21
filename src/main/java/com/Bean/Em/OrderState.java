package com.Bean.Em;

public class OrderState {
    /**
     * 等待付款
     **/
    public static Integer WAIT_PAY = 1;
    /**
     * 完成付款
     **/
    public static Integer COMPLETE_PAY = 2;
    /**
     * 运送中
     **/
    public static Integer TRANSPORTING = 3;
    /**
     * 完成收货
     **/
    public static Integer COMPLETED = 4;
    /**
     * 退款中
     **/
    public static Integer REFUNDING = 5;
    /**
     * 退款成功
     **/
    public static Integer COMPLETE_REFUND = 6;
}
