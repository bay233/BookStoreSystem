package com.BIz;

import com.Bean.Book;

import java.util.List;

public interface BookBiz {


    List<Book> queryBook(String name);

    Book queryBookById(Long uId);
}
