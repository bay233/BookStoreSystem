package com.Web.Controller;


import com.BIz.Impl.StatisticsBizImpl;
import com.Bean.PageBean;
import com.Common.Model.JsonModel;
import com.Common.Model.StockInfoView;
import com.Common.Model.TotalRecordView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/bookStore")
public class StatisticsController {

    @Autowired
    StatisticsBizImpl sbi;

    // 查看统计数据初始化
    @RequestMapping(value = "/recordInit", method = {RequestMethod.GET,RequestMethod.POST})
    private @ResponseBody
    JsonModel recordInit(){
        JsonModel jm = new JsonModel();
        try{
            PageBean<StockInfoView> obj = sbi.init();
            jm.setCode(1);
            jm.setObj(obj);
        }catch (Exception e){
            e.printStackTrace();
            jm.setCode(0);
        }
        return jm;
    }

    // 首页分页查询
    @RequestMapping(value = "/pageStockInfo")
    private @ResponseBody JsonModel pageStockInfo(HttpServletRequest request){
        Integer pageno = Integer.parseInt(request.getParameter("pageno"));
        JsonModel jm = new JsonModel();
        try{
            PageBean<StockInfoView> obj = sbi.pageStockInfo(pageno);
            jm.setCode(1);
            jm.setObj(obj);
        }catch (Exception e){
            e.printStackTrace();
            jm.setCode(0);
        }
        return jm;
    }

    // 查询某一件商品库存数量记录信息
    @RequestMapping(value = "/queryRecord", method = {RequestMethod.GET,RequestMethod.POST})
    private @ResponseBody JsonModel query(HttpServletRequest request){
        String bName = request.getParameter("bName");
        JsonModel jm = new JsonModel();
        try{
            StockInfoView[] obj = sbi.query(bName);
            jm.setCode(1);
            jm.setObj(obj);
        }catch (Exception e){
            e.printStackTrace();
            jm.setCode(0);
        }
        return jm;
    }

    // 获取一个商品的库存记录信息
    @RequestMapping(value ="/recordInfo", method={RequestMethod.GET, RequestMethod.POST})
    private @ResponseBody JsonModel recordInfo(HttpServletRequest request){
        Integer pageno = Integer.parseInt(request.getParameter("pageno"));
        Long bId = Long.parseLong(request.getParameter("bId"));
        JsonModel jm = new JsonModel();
        try{
            PageBean<StockInfoView> obj = sbi.recordInfo(pageno, bId);
            jm.setCode(1);
            jm.setObj(obj);
        }catch (Exception e){
            e.printStackTrace();
            jm.setCode(0);
        }
        return jm;
    }

    // 获取商品的销售记录信息
    @RequestMapping(value ="/orderInfo", method={RequestMethod.GET, RequestMethod.POST})
    private @ResponseBody JsonModel orderInfo(HttpServletRequest request){
        Integer pageno = Integer.parseInt(request.getParameter("pageno"));
        Long bId = Long.parseLong(request.getParameter("bId"));
        JsonModel jm = new JsonModel();
        try{
            PageBean<StockInfoView> obj = sbi.orderInfo(pageno, bId);
            jm.setCode(1);
            jm.setObj(obj);
        }catch (Exception e){
            e.printStackTrace();
            jm.setCode(0);
        }
        return jm;
    }

    // 获取商品的销售统计信息如：年，月，日
    @RequestMapping(value ="/totalRecord", method={RequestMethod.GET, RequestMethod.POST})
    private @ResponseBody
    JsonModel totalRecord(HttpServletRequest request){
        Long bId = Long.parseLong(request.getParameter("bId"));
        JsonModel jm = new JsonModel();
        try{
            TotalRecordView obj = sbi.totalRecord(bId);
            jm.setCode(1);
            jm.setObj(obj);
        }catch (Exception e){
            e.printStackTrace();
            jm.setCode(0);
        }
        return jm;
    }

}
