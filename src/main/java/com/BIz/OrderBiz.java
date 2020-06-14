package com.BIz;

import com.Bean.Order;

import java.util.List;
import java.util.Map;

public interface OrderBiz {

    List<Map<String,Object>> queryOrder(Long uId, Integer state);

    List<Map<String,Object>> queryOrder(Integer state);

    Order insertOrder(Order order);

    boolean updateByState(Long oId, Integer state);

    boolean addOrderInNum(Long oId, Integer state);

    boolean reduceOrderInNum(Long oId, Integer state);

    boolean nowPayment(Order order);
}
