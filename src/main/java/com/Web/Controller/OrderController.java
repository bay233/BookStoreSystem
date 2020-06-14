package com.Web.Controller;


import com.BIz.OrderBiz;
import com.Bean.Order;
import com.Common.Model.JsonModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/bookStore")
public class OrderController {


    @Autowired
    OrderBiz orderBiz;

    @RequestMapping(value = "/queryOrder", method = {RequestMethod.POST, RequestMethod.GET})
    private @ResponseBody
    JsonModel queryOrder(@RequestParam("uId") Long uId, @RequestParam("state") Integer state) {
        JsonModel jm = new JsonModel();
        List<Map<String, Object>> maps = orderBiz.queryOrder(uId, state);
        jm.setCode(1);
        jm.setObj(maps);
        return jm;
    }

    @RequestMapping(value = "/queryOrders", method = {RequestMethod.POST, RequestMethod.GET})
    private @ResponseBody
    JsonModel unfinishedOrder(@RequestParam("uId") Long uId, @RequestParam("states") String states) {
        String[] split = states.split(",");
        JsonModel jm = new JsonModel();
        List<Map<String, Object>> reslut = new ArrayList<>();
        for (String state : split) {
            List<Map<String, Object>> maps = orderBiz.queryOrder(uId, Integer.parseInt(state));
            reslut.addAll(maps);
        }
        jm.setCode(1);
        jm.setObj(reslut);
        return jm;
    }

    @RequestMapping(value = "/managementOrder", method = {RequestMethod.POST, RequestMethod.GET})
    private @ResponseBody
    JsonModel managementOrder(@RequestParam("state") Integer state) {
        JsonModel jm = new JsonModel();
        try {
            List<Map<String, Object>> reslut = orderBiz.queryOrder(state);
            jm.setCode(1);
            jm.setObj(reslut);
        } catch (Exception e) {
            e.printStackTrace();
            jm.setCode(0);
        }
        return jm;
    }


    @RequestMapping(value = "/updateByState", method = {RequestMethod.POST})
    private @ResponseBody
    JsonModel updateByState(@RequestParam("oId") Long oId, @RequestParam("state") Integer state) {
        JsonModel jm = new JsonModel();
        if (orderBiz.updateByState(oId, state)) {
            jm.setCode(1);
        } else {
            jm.setCode(0);
        }
        return jm;
    }


    @RequestMapping(value = "/insertCart", method = {RequestMethod.POST})
    private @ResponseBody
    JsonModel insertCart(Order order) {
        JsonModel jm = new JsonModel();
        Order o = orderBiz.insertOrder(order);
        if (o == null) {
            jm.setCode(0);
        } else {
            jm.setCode(1);
        }
        return jm;
    }

    @RequestMapping(value = "/payment", method = {RequestMethod.POST})
    private @ResponseBody
    JsonModel payment(@RequestParam("oId") Long oId, @RequestParam("state") Integer state) {
        JsonModel jm = new JsonModel();
        if (orderBiz.reduceOrderInNum(oId, state)) {
            jm.setCode(1);
        } else {
            jm.setCode(0);
        }
        return jm;
    }

    @RequestMapping(value = "/nowPayment", method = {RequestMethod.POST})
    private @ResponseBody
    JsonModel nowPayment(Order order) {
        JsonModel jm = new JsonModel();
        if (orderBiz.nowPayment(order)) {
            jm.setCode(1);
        } else {
            jm.setCode(0);
        }
        return jm;
    }


    @RequestMapping(value = "/refund", method = {RequestMethod.POST})
    private @ResponseBody
    JsonModel refund(@RequestParam("oId") Long oId, @RequestParam("state") Integer state) {
        JsonModel jm = new JsonModel();
        if (orderBiz.addOrderInNum(oId, state)) {
            jm.setCode(1);
        } else {
            jm.setCode(0);
        }
        return jm;
    }


}
