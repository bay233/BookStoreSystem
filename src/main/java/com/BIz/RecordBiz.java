package com.BIz;

import com.Bean.Book;
import com.Bean.Record;

public interface RecordBiz {

    /**
     * 添加商品
     * @param book  传入不带id号的Book实体 其中num属性表示初始数量
     * @return  返回带有自动生成id的Book实体
     */
    Record insertGoods(Book book);

    /**
     * 传入一个商品id
     * @param bId
     */
    void deleteGoods(Long bId);

    void deleteGoods(Book book);

    /**
     * 添加库存
     * @param record 传入只有bid和num属性的Record对象
     */
    void addStock(Record record);

    /**
     * 添加库存
     * @param bId  商品id
     * @param num  变化数量
     */
    void addStock(Long bId, Integer num);

    /**
     * 减少库存
     */
    void subtractStock(Record record);

    void subtractStock(Long bId, Integer num);
}
