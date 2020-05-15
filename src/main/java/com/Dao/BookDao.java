package com.Dao;

import com.Bean.Book;

public interface BookDao {
    /**
     * 根据商品id查询商品信息，主要用于与其他表进行连接查询
     * @param uId  商品信息
     * @return  返回Book对象
     */
    Book query(Long uId);


    /**
     * 根据商品名进查询，主要提供给商品查找
     * @param name   输入关键字
     * @return  放回Book对象
     */
    Book query(String name);

    /**
     * 对bName进行模糊查询
     */
    Book[] queryDim(String name);


    /**
     * 对bName进行正则表达式匹配
     * @param RegexpName 传入正则表达式字符串
     */
    Book[] queryRegexp(String RegexpName);

    /**
     * 分页查询，传入一个Book，根据对象的属性值进行筛选查询, 不支持{picture，price，num}属性查询，我们认为
     * 以这三个列作为查询添加毫无意义
     * @param book  Book对象
     * @param start  开始的行数
     * @param pageNum   每一页的数量
     * @return  数组
     */
    Book[] queryLimit(Book book, Integer start, Integer pageNum);

    Book[] queryLimit(Integer start, Integer pageNum);

    /**
     * 对属性进正则表达式匹配，输入的属性均为正则表达式
     */
    Book[] queryRegexpLimit(Book book, Integer start, Integer pageNum);

    /**
     * 添加商品
     * @param book   商品对象
     * @return   返回刚刚创建的Book对象  包含自动创建的Id号
     */
    Book addBook(Book book);

    /**
     * 删除一件商品
     * @param uId  商品的id
     */
    void deleteBook(Long uId);



}
