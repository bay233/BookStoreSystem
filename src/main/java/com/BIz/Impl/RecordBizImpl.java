package com.BIz.Impl;

import com.BIz.RecordBiz;
import com.Bean.Book;
import com.Bean.Record;
import com.Dao.BookDao;
import com.Dao.RecordDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RecordBizImpl implements RecordBiz {

    @Autowired
    private RecordDao rd;

    @Autowired
    private BookDao bd;

    @Override
    public Record insertGoods(Book book) {
        if (book.getbName() == null || book.getPrice() == null) {
            try {
                throw new Exception("Book object is missing Name or Price attribute");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        // 添加商品
        Book b = bd.addBook(book);
        // 添加记录
        Record r = new Record();
        r.setbId(b.getbId());
        r.setNum(b.getNum());
        Record record = rd.addRecord(r);
        return record;
    }

    @Override
    public void deleteGoods(Long bId) {
        // 获取剩余商品数
        Book b = bd.query(bId);
        Integer num = b.getNum();
        Record r = new Record();
        r.setbId(bId);
        r.setNum(-num);
        updateStock(r);
    }

    @Override
    public void deleteGoods(Book book) {
        deleteGoods(book.getbId());
    }

    @Override
    public void addStock(Record record) {
        updateStock(record);
    }

    @Override
    public void addStock(Long bId, Integer num) {
        Record r = new Record();
        r.setbId(bId);
        r.setNum(num);
        addStock(r);

    }

    @Override
    public void subtractStock(Record record) {
        if (record.getNum() > 0) {
            record.setNum(-record.getNum());
        }
        updateStock(record);
    }

    @Override
    public void subtractStock(Long bId, Integer num) {
        Record r = new Record();
        r.setbId(bId);
        r.setNum(num);
        subtractStock(r);
    }

    private void updateStock(Record record) {
        if (record.getbId() == null || record.getNum() == null) {
            try {
                throw new Exception("Record object is missing attribute Name or Price");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        // 修改库存
        bd.updateNum(record.getbId(), record.getNum());
        // 添加记录
        Record r = new Record();
        r.setbId(record.getbId());
        r.setNum(record.getNum());
        rd.addRecord(r);
    }
}
