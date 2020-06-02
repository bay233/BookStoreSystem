package com.Web.Controller;


import com.BIz.Impl.StatisticsBizImpl;
import com.Bean.PageBean;
import com.Common.Model.StockInfoView;
import com.Common.Model.TotalRecordView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("bookStore")
public class StatisticsController {

    @Autowired
    StatisticsBizImpl sbi;

    // 查看统计数据初始化
    @RequestMapping(value = "/recordInit", method = {RequestMethod.GET,RequestMethod.POST})
    private @ResponseBody
    PageBean<StockInfoView> recordInit(){
        return sbi.init();
    }

    // 首页分页查询
    @RequestMapping(value = "/pageStockInfo")
    private @ResponseBody PageBean<StockInfoView> pageStockInfo(HttpServletRequest request){
        Integer pageno = Integer.parseInt(request.getParameter("pageno"));
        return sbi.pageStockInfo(pageno);
    }

    // 查询某一件商品库存数量记录信息
    @RequestMapping(value = "/queryRecord", method = {RequestMethod.GET,RequestMethod.POST})
    private @ResponseBody StockInfoView[] query(HttpServletRequest request){
        String bName = request.getParameter("bName");
        return sbi.query(bName);
    }

    // 获取一个商品的库存记录信息
    @RequestMapping(value ="/recordInfo", method={RequestMethod.GET, RequestMethod.POST})
    private @ResponseBody PageBean<StockInfoView> recordInfo(HttpServletRequest request){
        Integer pageno = Integer.parseInt(request.getParameter("pageno"));
        Long bId = Long.parseLong(request.getParameter("bId"));
        return sbi.orderInfo(pageno, bId);
    }

    // 获取商品的销售记录信息
    @RequestMapping(value ="/orderInfo", method={RequestMethod.GET, RequestMethod.POST})
    private @ResponseBody PageBean<StockInfoView> orderInfo(HttpServletRequest request){
        Integer pageno = Integer.parseInt(request.getParameter("pageno"));
        Long bId = Long.parseLong(request.getParameter("bId"));
        return sbi.orderInfo(pageno, bId);
    }

    // 获取商品的销售统计信息如：年，月，日
    @RequestMapping(value ="/totalRecord", method={RequestMethod.GET, RequestMethod.POST})
    private @ResponseBody
    TotalRecordView totalRecord(HttpServletRequest request){
        Long bId = Long.parseLong(request.getParameter("bId"));
        return sbi.totalRecord(bId);
    }

}
