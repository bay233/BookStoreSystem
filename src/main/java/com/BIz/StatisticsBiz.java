package com.BIz;

import com.Bean.PageBean;
import com.Common.Model.StockInfoView;
import com.Common.Model.TotalRecordView;

public interface StatisticsBiz {

    Integer PAGENUM = 16;
    /**
     * 初始化查看库存数，获取按bId升序排列的商品的库存数
     * StockView 是一个带商品id，name，num的对象  用于封装查询库存结果
     * @return 返回StockView数组
     */
    PageBean<StockInfoView> init();


    PageBean<StockInfoView> pageStockInfo(Integer pageno);

    /**
     * 根据商品名查询商品库存
     * 因为有可能是使用模糊匹配或者是正则表达式匹配，结果可能不唯一 所以返回一个集合
     * @param bName  需要查询的关键字
     * @return  返回StockView数组
     */
    StockInfoView[] query(String bName);

    /**
     * 获取一个商品的库存记录信息
     * @param bId 商品Id
     * @return  Record为库存变化记录信息
     */
    PageBean<StockInfoView> recordInfo(Integer pageno ,Long bId);

    /**
     * 获取商品的销售记录信息
     */
    PageBean<StockInfoView> orderInfo(Integer pageno ,Long bId);


    /**
     * 获取一个商品：总的销量
     *     每年的销量
     *     每个月的销量
     *     每天的销量
     * @param bId  该商品的ID
     * @return 返回TotalRecordView对象，该对象封装了上述查找的数据
     */
    TotalRecordView totalRecord(Long bId);

}
