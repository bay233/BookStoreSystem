package com.BIz.Impl;

import com.BIz.BookBiz;
import com.Bean.Book;
import com.Dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class BookBizImpl implements BookBiz {

    @Autowired
    BookDao bookdao;


    @Override
    public List<Book> queryBook(String name) {
        Book[] books = bookdao.queryDim(name);
        List<Book> list = Arrays.asList(books);
        return list;
    }

    @Override
    public Book queryBookById(Long uId) {
        return bookdao.query(uId);
    }
}
