package com.Web.Controller;


import com.BIz.RecordBiz;
import com.Bean.Book;
import com.Bean.Record;
import com.Common.Model.JsonModel;
import com.Common.Utils.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("bookStore")
public class RecordController {

    @Autowired
    private RecordBiz rb;

    @RequestMapping(value = "/addGoods", method = {RequestMethod.POST})
    private @ResponseBody
    JsonModel addGoods(Book book) {
        JsonModel jm = new JsonModel();
        try {
            rb.insertGoods(book);
            jm.setCode(1);
        } catch (Exception e) {
            Log.log.error(e.getMessage());
            jm.setCode(0);
        }
        return jm;
    }

    @RequestMapping(value = "/deleteGoods", method = {RequestMethod.POST})
    private @ResponseBody
    JsonModel deleteGoods(Book book) {
        JsonModel jm = new JsonModel();
        try {
            rb.deleteGoods(book);
            jm.setCode(1);
        } catch (Exception e) {
            Log.log.error(e.getMessage());
            jm.setCode(0);
        }
        return jm;
    }

    @RequestMapping(value = "/addStock", method = {RequestMethod.POST})
    private @ResponseBody
    JsonModel addStock(Record record) {
        JsonModel jm = new JsonModel();
        try {
            rb.addStock(record);
            jm.setCode(1);
        } catch (Exception e) {
            Log.log.error(e.getMessage());
            jm.setCode(0);
        }
        return jm;
    }

    @RequestMapping(value = "/subtractStock", method = {RequestMethod.POST})
    private @ResponseBody
    JsonModel subtractStock(Record record) {
        JsonModel jm = new JsonModel();
        try {
            rb.subtractStock(record);
            jm.setCode(1);
        } catch (Exception e) {
            Log.log.error(e.getMessage());
            jm.setCode(0);
        }
        return jm;
    }

}
