package com.Web.Controller;

import com.BIz.BookBiz;
import com.Bean.Book;
import com.Common.Model.JsonModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.websocket.server.PathParam;
import java.util.List;

@Controller
@RequestMapping("/bookStore")
public class BookController {

    @Autowired
    BookBiz bookBiz;

    @RequestMapping(value = "/queryBook", method = {RequestMethod.POST, RequestMethod.GET})
    private @ResponseBody
    JsonModel queryBook(@PathParam("key") String key){
        JsonModel jm = new JsonModel();
        List<Book> books = bookBiz.queryBook(key);
        if (books.size() <= 0){
           jm.setCode(0);
           return jm;
        }
        jm.setCode(1);
        jm.setObj(books);
        return jm;
    }



}
