package com.Dao;

import com.Bean.Order;

public interface OrderDao {

    /**
     * 查询订单信息
     * @param oId  订单Id
     * @return 返回Order对象
     */
    Order query(Long oId);

    /**
     * 根据用户id查询订单
     * @param uId  用户id
     * @return  返回Order对象数组
     */
    Order[] queryByUid(Long uId);

    /**
     * 根据商品id查询订单
     * @param bId  商品id
     * @return 返回Order对象数组
     */
    Order[] queryByBid(Long bId);

    /**
     * 根据状态值查询订单
     * @param state  状态值
     */
    Order[] queryByState(Integer state);

    /**
     * 分页查询，根据Order对象的属性值筛选结果，同时我们认为{num,adder,phone}作为为条件查询是无意义的
     * 所以该方法不支持以上属性的条件。
     * @param order Order对象
     * @param order  Book对象
     * @param start  开始的行数
     * @param pageNum   每一页的数量
     * @return  数组
     */
    Order[] queryLimit(Order order, Integer start, Integer pageNum);

    Order[] queryLimit(Integer start, Integer pageNum);

    /**
     * 添加订单记录
     * @param order  传入没有oId值得order对象
     * @return  放回有oId值得order对象
     */
    Order addOrder(Order order);

    /**
     * 修改订单状态
     * @param oId  订单Id
     * @return  返回修改后状态编号
     */
    void setState(Long oId, Integer state);

}
