package com.BIz.Impl;

import com.BIz.StatisticsBiz;
import com.Bean.Book;
import com.Bean.Order;
import com.Bean.PageBean;
import com.Bean.Record;
import com.Common.Model.StockInfoView;
import com.Common.Model.TotalRecordView;
import com.Dao.BookDao;
import com.Dao.OrderDao;
import com.Dao.RecordDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Service
public class StatisticsBizImpl implements StatisticsBiz {

    @Autowired
    private BookDao bd;

    @Autowired
    private RecordDao rd;

    @Autowired
    private OrderDao od;

    @Override
    public PageBean<StockInfoView> init() {
        return pageStockInfo(1);
    }

    @Override
    public PageBean<StockInfoView> pageStockInfo(Integer pageno) {
        Integer start = (pageno - 1) * this.PAGENUM;
        PageBean<StockInfoView> page = new PageBean<>();
        Book[] books = bd.queryLimit(start, this.PAGENUM);
        List<StockInfoView> list = book2StockInfoView(books);
        page.setList(list);
        page.setTotal(bd.count());
        page.setPagesize(this.PAGENUM);
        page.setPageno(pageno);
        return page;
    }

    @Override
    public StockInfoView[] query(String bName) {
        Book[] books = bd.queryDim(bName);
        List<StockInfoView> list = book2StockInfoView(books);
        return list.toArray(new StockInfoView[list.size()]);
    }


    /**
     *
     * @param pageno  分页页号
     * @param bId 商品Id
     * @return  返回StockInfoView中bName为空
     */
    @Override
    public PageBean<StockInfoView> recordInfo(Integer pageno, Long bId) {
        Integer start = (pageno - 1) * this.PAGENUM;
        Record[] records = rd.queryLimit(bId, start, this.PAGENUM);
        PageBean<StockInfoView> page = new PageBean<>();
        List<StockInfoView> list = new ArrayList<>();
        for(Record r : records){
            StockInfoView siv = new StockInfoView();
            siv.setbId(r.getbId());
            siv.setDateTime(r.getDateTime());
            siv.setNum(r.getNum());
            list.add(siv);
        }
        page.setTotal(rd.query(bId).length);
        page.setList(list);
        page.setPagesize(this.PAGENUM);
        page.setPageno(pageno);
        return page;
    }

    /**
     *
     * @param pageno  分页页号
     * @param bId 商品Id
     * @return  返回StockInfoView中bName为空
     */
    @Override
    public PageBean<StockInfoView> orderInfo(Integer pageno, Long bId) {
        Order order = new Order();
        order.setbId(bId);
        Integer start = (pageno - 1) * this.PAGENUM;
        Order[] orders = od.queryLimit(order, start, this.PAGENUM);
        PageBean<StockInfoView> page = new PageBean<>();
        List<StockInfoView> list = new ArrayList<>();
        for (Order o : orders){
            StockInfoView siv = new StockInfoView();
            siv.setbId(o.getbId());
            siv.setNum(o.getNum());
            siv.setDateTime(o.getDateTime());
            list.add(siv);
        }
        page.setTotal(od.queryByBid(bId).length);
        page.setList(list);
        page.setPagesize(this.PAGENUM);
        page.setPageno(pageno);
        return page;
    }

    @Override
    public TotalRecordView totalRecord(Long bId) {
        List<Map<String, String>> Gyear = od.queryTotalByYear(bId);
        List<Map<String, String>> Gmath = od.queryTotalByMath(bId);
        List<Map<String, String>> Gday = od.queryTotalByDay(bId);
        TotalRecordView trv = new TotalRecordView();
        trv.setGroupYear(Gyear);
        trv.setGroupMath(Gmath);
        trv.setGroupDay(Gday);
        Long num = 0L;
        for(Map<String, String> m: Gyear){
            num += Long.parseLong(m.get("num"));
        }
        for(Map<String, String> m: Gmath){
            num += Long.parseLong(m.get("num"));
        }
        for(Map<String, String> m: Gday){
            num += Long.parseLong(m.get("num"));
        }
        trv.setTotal(num);
        return trv;
    }



    private List<StockInfoView> book2StockInfoView(Book[] books) {
        List<StockInfoView> list = new ArrayList<>();
        for (Book b : books) {
            StockInfoView siv = new StockInfoView();
            siv.setbId(b.getbId());
            siv.setbName(b.getbName());
            siv.setNum(b.getNum());
            list.add(siv);
        }
        return list;
    }
}
