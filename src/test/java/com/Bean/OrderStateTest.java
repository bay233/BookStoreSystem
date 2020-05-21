package com.Bean;

import com.Bean.Em.OrderState;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)   // 请导入    spring-test包
//@ContextConfiguration(classes = {AppConfig.class})    //IOC
public class OrderStateTest {

    @Test
    public void printState(){
        System.out.println(OrderState.WAIT_PAY);
        System.out.println(OrderState.COMPLETE_PAY);
        System.out.println(OrderState.TRANSPORTING);
        System.out.println(OrderState.COMPLETED);
        System.out.println(OrderState.REFUNDING);
        System.out.println(OrderState.COMPLETE_REFUND);

    }

}
