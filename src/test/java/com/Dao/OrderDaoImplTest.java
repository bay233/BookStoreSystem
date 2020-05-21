package com.Dao;

import com.Bean.Order;
import com.Config.AppConfig;
import com.Dao.Impl.OrderDaoImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)   // 请导入    spring-test包
@ContextConfiguration(classes = {AppConfig.class})    //IOC
public class OrderDaoImplTest {

    @Autowired
    private OrderDaoImpl odi;

    @Test
    public void query(){
        Order o = odi.query(1L);
        assert o != null;
    }

    @Test
    public void queryByUid(){
        Order[] o = odi.queryByUid(1L);
        assert o != null;
    }

    @Test
    public void queryByBid(){
        Order[] orders = odi.queryByBid(1L);
        assert orders != null;
    }

    @Test
    public void queryByState(){
        Order[] orders = odi.queryByState(1);
        assert orders!=null;
    }

    @Test
    public void queryLimit(){
        Order[] orders = odi.queryLimit(0, 1);
        assert orders != null;
    }

}
