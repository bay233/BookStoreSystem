package com.Dao.Impl;

import com.Bean.Order;
import com.Dao.OrderDao;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class OrderDaoImpl implements OrderDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    private void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public Long count() {
        return jdbcTemplate.query("select count(oId) from orders", (rs, rowNum) -> {
            return rs.getLong(1);
        }).get(0);
    }

    @Override
    public Order query(Long oId) {
        return jdbcTemplate.queryForObject("select * from orders where oId=?",
                (rs, rowNum) -> {
                    return setOrder(rs);
                }, oId);
    }


    @Override
    public Order[] queryByUid(Long uId) {
        List<Order> orders = jdbcTemplate.query("select * from orders where uId=?",
                (rs, rowNum) -> {
                    return setOrder(rs);
                }, uId);
        return orders.toArray(new Order[orders.size()]);
    }

    @Override
    public Order[] queryByBid(Long bId) {
        List<Order> orders = jdbcTemplate.query("select * from orders where bId=?",
                (rs, rowNum) -> {
                    return setOrder(rs);
                }, bId);
        return orders.toArray(new Order[orders.size()]);
    }

    @Override
    public Order[] queryByState(Integer state) {
        List<Order> orders = jdbcTemplate.query("select * from orders where state=?",
                (rs, rowNum) -> {
                    return setOrder(rs);
                }, state);
        return orders.toArray(new Order[orders.size()]);
    }

    @Override
    public Order[] queryByState(Long uId, Integer state) {
        List<Order> orders = jdbcTemplate.query("select * from orders where uId=? and state=?",
                (rs, rowNum) -> {
                    return setOrder(rs);
                },uId,state);
        return orders.toArray(new Order[orders.size()]);
    }

    @Override
    public Order[] queryLimit(Order order, Integer start, Integer pageNum) {
        String sql = "select * from orders where 1=1 ";
        List<Object> obj = new ArrayList<>();
        if (order != null) {
            if (order.getoId() != null) {
                Order[] os = new Order[1];
                os[0] = query(order.getbId());
                return os;
            }
            if (order.getuId() != null) {
                sql += " and uId=? ";
                obj.add(order.getuId());
            }
            if (order.getbId() != null) {
                sql += " and bId=? ";
                obj.add(order.getbId());
            }
            if (order.getDateTime() != null) {
                sql += " and dateTime>? ";
                obj.add(order.getDateTime());
            }
            if (order.getState() != null) {
                sql += " and state=? ";
                obj.add(order.getState());
            }
        }
        sql += " limit ?,? ";
        obj.add(start);
        obj.add(pageNum);
        List<Order> orders = jdbcTemplate.query(sql, (rs, rowNum) -> {
            return setOrder(rs);
        }, obj.toArray());
        return orders.toArray(new Order[orders.size()]);
    }

    @Override
    public Order[] queryLimit(Integer start, Integer pageNum) {
        return queryLimit(null, start, pageNum);
    }

    @Override
    public Order addOrder(Order order) {
        String sql = "insert into orders values(oId,?,?,?,?,?,?,now())";
        // 使用回调机制返回新添加的数据的自增列值，这里是返回uId
        KeyHolder kh = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setLong(1, order.getuId());
            ps.setLong(2, order.getbId());
            ps.setInt(3, order.getNum());
            ps.setString(4, order.getAddr());
            ps.setLong(5, order.getPhone());
            ps.setInt(6, order.getState());
            return ps;
        }, kh);
        Long key = kh.getKey().longValue();
        order.setoId(key);
        return order;
    }

    @Override
    public void setState(Long oId, Integer state) {
        jdbcTemplate.update("update orders set state=? where oId=?", state, oId);
    }

    @Override
    public  List<Map<String, String>> queryTotalByYear(Long bId) {
        List<Map<String, String>> query = jdbcTemplate.query("SELECT DATE_FORMAT(dateTime, '%Y' ),SUM( `num`) FROM orders WHERE bId=? GROUP BY DATE_FORMAT( dateTime, '%Y')", (rs, rowNum) -> {
            Map<String, String> map = new HashMap<>();
            map.put("date", rs.getString(1));
            map.put("num", rs.getString(2));
            return map;
        }, bId);
        return query;
    }

    @Override
    public List<Map<String, String>> queryTotalByMath(Long bId) {
        List<Map<String, String>> query = jdbcTemplate.query("SELECT DATE_FORMAT( dateTime, '%Y-%m' ),SUM( `num`) FROM orders WHERE bId=? GROUP BY DATE_FORMAT( dateTime, '%Y-%m')", (rs, rowNum) -> {
            Map<String, String> map = new HashMap<>();
            map.put("date", rs.getString(1));
            map.put("num", rs.getString(2));
            return map;
        }, bId);
        return query;
    }

    @Override
    public List<Map<String, String>> queryTotalByDay(Long bId) {
        List<Map<String, String>> query = jdbcTemplate.query("SELECT DATE_FORMAT( dateTime, '%Y-%m-%d' ),SUM( `num`) FROM orders WHERE bId=? GROUP BY DATE_FORMAT( dateTime, '%Y-%m-%d')", (rs, rowNum) -> {
            Map<String, String> map = new HashMap<>();
            map.put("date", rs.getString(1));
            map.put("num", rs.getString(2));
            return map;
        }, bId);
        return query;
    }


    private Order setOrder(ResultSet rs) throws SQLException {
        Order o = new Order();
        o.setoId(rs.getLong(1));
        o.setuId(rs.getLong(2));
        o.setbId(rs.getLong(3));
        o.setNum(rs.getInt(4));
        o.setAddr(rs.getString(5));
        o.setPhone(rs.getLong(6));
        o.setState(rs.getInt(7));
        o.setDateTime(rs.getTimestamp(8));
        return o;
    }
}
