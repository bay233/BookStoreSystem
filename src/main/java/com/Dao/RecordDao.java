package com.Dao;

import com.Bean.Record;

public interface RecordDao {

    /**
     * 获取数据总数
     */
    Long count();

    /**
     * 更具商品Id获取库存记录
     * @param bId
     * @return
     */
    Record[] query(Long bId);

    /**
     * 获取所有库存记录
     */
    Record[] queryAll();

    /**
     * 分页获取
     * @param bid
     * @param start
     * @param pageNum
     * @return
     */
    Record[] queryLimit(Long bid, Integer start, Integer pageNum);

    Record[] queryLimit(Integer start, Integer pageNum);

    /**
     * 添加记录
     * @param record
     * @return
     */
    Record addRecord(Record record);
}
