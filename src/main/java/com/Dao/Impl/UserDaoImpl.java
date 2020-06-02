package com.Dao.Impl;

import com.Bean.User;
import com.Dao.UserDao;
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
public class UserDaoImpl implements UserDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    private void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Long count() {
        return jdbcTemplate.query("select count(uId) from user",(rs, rowNum) -> {
            return rs.getLong(1);
        }).get(0);
    }

    @Override
    public User query(Long uId) {
        User user = jdbcTemplate.queryForObject("select * from user where uId=?", (rs, rowNum) -> {
            return setUser(rs);
        }, uId);
        return user;
    }

    @Override
    public User[] queryLimit(User user, Integer start, Integer pageNum) {
        String sql = "select * from user where 1=1 ";
        List<Object> obj = new ArrayList<>();
        if (user != null) {
            if (user.getuId() != null) {
                User[] us = new User[1];
                us[0] = query(user.getuId());
                return us;
            }
            if (user.getuEmai() != null) {
                sql += " and uEmai=? ";
                obj.add(user.getuEmai());
            }
            if (user.getuPwd() != null) {
                sql += " and uPwd=? ";
                obj.add(user.getuPwd());
            }
            if (user.getuName() != null) {
                sql += " and uName=? ";
                obj.add(user.getuName());
            }
        }
        sql += " limit ?,? ";
        obj.add(start);
        obj.add(pageNum);
        List<User> users = jdbcTemplate.query(sql, (rs, rowNum) -> {
            return setUser(rs);
        }, obj.toArray());
        return users.toArray(new User[users.size()]);
    }

    @Override
    public User[] queryLimit(Integer start, Integer pageNum) {
        return queryLimit(null, start, pageNum);
    }

    @Override
    public User addUser(User user) {
        String sql = "insert into user values(uId,?,?,?)";
        // 使用回调机制返回新添加的数据的自增列值，这里是返回uId
        KeyHolder kh = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getuEmai());
            ps.setString(2, user.getuPwd());
            ps.setString(3, user.getuName());
            return ps;
        }, kh);
        Long key = kh.getKey().longValue();
        user.setuId(key);
        return user;
    }

    @Override
    public User[] queryAll() {
        List<User> users = jdbcTemplate.query("select * from user",
                (rs, rowNum) -> {
                    return setUser(rs);
                });
        return users.toArray(new User[users.size()]);
    }


    private User setUser(ResultSet rs) throws SQLException {
        User user = new User();
        user.setuId(rs.getLong(1));
        user.setuEmai(rs.getString(2));
        user.setuPwd(rs.getString(3));
        user.setuName(rs.getString(4));
        return user;
    }
}
