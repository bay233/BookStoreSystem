package com.Dao.Impl;

import com.Bean.Book;
import com.Dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BookDaoImpl implements BookDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    private void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Book query(Long uId) {
        return jdbcTemplate.queryForObject("select * from book where bId=?",
                (rs, rowNum) -> {
                    return setBook(rs);
                }, uId);
    }

    /**
     * 根据name进行精准查询
     *
     * @param name 输入关键字
     */
    @Override
    public Book query(String name) {
        return jdbcTemplate.queryForObject("select * from book where bName=?",
                (rs, rowNum) -> {
                    return setBook(rs);
                }, name);
    }


    /**
     * 使用数据Like "%key%" 进行模糊查询
     *
     * @param name 传入关键字（可不带%）
     */
    @Override
    public Book[] queryDim(String name) {
        String sql = "select * from book where bName=?";
        name = "%" + name + "%";
        List<Book> books = jdbcTemplate.query(sql,
                (rs, rowNum) -> {
                    return setBook(rs);
                }, name);
        return books.toArray(new Book[books.size()]);
    }

    /**
     * 使用正则表达式查询商品
     *
     * @param RegexpName 带正则表达式的关键字关键字
     */
    @Override
    public Book[] queryRegexp(String RegexpName) {
        String sql = "select * from book where bName REGEXP ?";
        List<Book> books = jdbcTemplate.query(sql,
                (rs, rowNum) -> {
                    return setBook(rs);
                }, RegexpName);
        return books.toArray(new Book[books.size()]);
    }

    //------------------------------------
    //    分页查询
    //------------------------------------
    @Override
    public Book[] queryLimit(Book book, Integer start, Integer pageNum) {
        String sql = "select * from book where 1=1 ";
        List<Object> obj = new ArrayList<>();
        if (book != null) {
            if (book.getbId() != null) {
                Book[] bs = new Book[1];
                bs[0] = query(book.getbId());
                return bs;
            }
            if (book.getbName() != null) {
                sql += " and bName=? ";
                obj.add(book.getbName());
            }
            if (book.getExplain() != null) {
                sql += " and explain=? ";
                obj.add(book.getExplain());
            }
            if (book.getSort() != null) {
                sql += " and sort=? ";
                obj.add(book.getSort());
            }
        }
        sql += " limit ?,? ";
        obj.add(start);
        obj.add(pageNum);
        List<Book> books = jdbcTemplate.query(sql, (rs, rowNum) -> {
            return setBook(rs);
        }, obj.toArray());
        return books.toArray(new Book[books.size()]);
    }


    @Override
    public Book[] queryLimit(Integer start, Integer pageNum) {
        return queryLimit(null, start, pageNum);
    }

    @Override
    public Book[] queryRegexpLimit(Book book, Integer start, Integer pageNum) {
        String sql = "select * from book where 1=1 ";
        List<Object> obj = new ArrayList<>();
        if (book != null) {
            if (book.getbId() != null) {
                Book[] bs = new Book[1];
                bs[0] = query(book.getbId());
                return bs;
            }
            if (book.getbName() != null) {
                sql += " and bName Regexp ? ";
                obj.add(book.getbName());
            }
            if (book.getExplain() != null) {
                sql += " and explain Regexp ? ";
                obj.add(book.getExplain());
            }
            if (book.getSort() != null) {
                sql += " and sort Regexp ? ";
                obj.add(book.getSort());
            }
        }
        sql += " limit ?,? ";
        obj.add(start);
        obj.add(pageNum);
        List<Book> Books = jdbcTemplate.query(sql, (rs, rowNum) -> {
            return setBook(rs);
        }, obj.toArray());
        return Books.toArray(new Book[Books.size()]);
    }


    @Override
    public Book addBook(Book book) {
        String sql = "insert into book values(bId,?,?,?,?,?,?)";
        // 使用回调机制返回新添加的数据的自增列值，这里是返回uId
        KeyHolder kh = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, book.getbName());
            ps.setString(2, book.getExplain());
            ps.setString(3, book.getPicture());
            ps.setString(4, book.getSort());
            ps.setDouble(5, book.getPrice());
            ps.setInt(6, book.getNum());
            return ps;
        }, kh);
        Long key = kh.getKey().longValue();
        book.setbId(key);
        return book;
    }

    @Override
    public void deleteBook(Long uId) {
        jdbcTemplate.update("delete from book where uId=?", uId);
    }


    private Book setBook(ResultSet rs) throws SQLException {
        Book book = new Book();
        book.setbId(rs.getLong(1));
        book.setbName(rs.getString(2));
        book.setExplain(rs.getString(3));
        book.setPicture(rs.getString(4));
        book.setSort(rs.getString(5));
        book.setPrice(rs.getDouble(6));
        book.setNum(rs.getInt(7));
        return book;
    }
}
