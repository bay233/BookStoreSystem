package com.BIz.Impl;

import com.BIz.OrderBiz;
import com.Bean.Book;
import com.Bean.Order;
import com.Dao.BookDao;
import com.Dao.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


@Service
@Transactional
public class OrderBizImpl implements OrderBiz {


    @Autowired
    OrderDao orderDao;
    @Autowired
    BookDao bookDao;

    @Override
    public List<Map<String, Object>> queryOrder(Long uId, Integer state) {
        List<Order> orders;
        if (uId <= 0){
            Order[] orderArr = orderDao.queryByState(state);
            orders = Arrays.asList(orderArr);
        }else{
            Order[] orderArr = orderDao.queryByState(uId, state);
            orders = Arrays.asList(orderArr);
        }
        List<Map<String, Object>> reslut = new ArrayList<>();
        if (orders.size() > 0) {
            for (Order o : orders) {
                Book book = bookDao.query(o.getbId());
                Map<String, Object> map = new HashMap<>();
                map.put("order", o);
                map.put("book", book);
                reslut.add(map);
            }
        }
        return reslut;
    }

    @Override
    public List<Map<String, Object>> queryOrder(Integer state) {
        return queryOrder(0L, state);
    }

    @Override
    public Order insertOrder(Order order) {
        try {
            Order o = orderDao.addOrder(order);
            return o;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean updateByState(Long oId, Integer state) {
        try {
            orderDao.setState(oId,state);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean addOrderInNum(Long oId, Integer state) {
        try {
            Order order = orderDao.query(oId);
            Book book = bookDao.query(order.getbId());
            bookDao.updateNum(book.getbId(), order.getNum());
            orderDao.setState(oId, state);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean reduceOrderInNum(Long oId, Integer state) {
        try {
            Order order = orderDao.query(oId);
            Book book = bookDao.query(order.getbId());
            if (order.getNum() <= book.getNum()) {
                bookDao.updateNum(book.getbId(),  - order.getNum());
                orderDao.setState(oId, state);
                return true;
            }
            return false;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean nowPayment(Order order) {
        try {
            Book book = bookDao.query(order.getbId());
            if (order.getNum() <= book.getNum()) {
                bookDao.updateNum(book.getbId(),  - order.getNum());
                orderDao.addOrder(order);
                return true;
            }
            return false;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
