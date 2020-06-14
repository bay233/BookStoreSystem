package com.Dao;

import com.Bean.User;

public interface UserDao {

    Long count();

    /**
     * 根据用户Id查一个用户的信息
     * @param uId   用户Id
     * @return    放回一个User对象
     */
    User query(Long uId);

    boolean query(String uEmail);

    User loginByEmail(String uEmail);

    /**
     * 分页查询，查询条件，如为User对象空则按主键顺序，若不为空，则根据对象中的属性进行查询
     * @param user  传入User对象（若要根据uEmai查询  则只需要set.uEmai()将值传入即可）
     * @param start   开始的行数
     * @param pageNum  每一页的数量
     * @return   返回User数组
     */
    User[] queryLimit(User user, Integer start, Integer pageNum);

    User[] queryLimit(Integer start, Integer pageNum);
    /**
     * 添加一个用户，传入一个没Id值得对象
     * @param user  一个没有Id值得对象User对象
     * @return   放回新建的User对象，该对象包含自动获取的uId值
     */
    User addUser(User user);

    /**
     * 返回所有的用户信息
     * @return  放回User[]
     */
    User[] queryAll();
}
