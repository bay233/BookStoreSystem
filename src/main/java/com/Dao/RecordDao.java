package com.Dao;

import com.Bean.Record;

public interface RecordDao {

    Record[] query(Long bId);

    Record[] queryAll();

    Record[] queryLimit(Long bid, Integer start, Integer pageNum);

    Record[] queryLimit(Integer start, Integer pageNum);

    Record addRecord(Record record);
}
