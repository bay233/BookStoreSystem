package com.Dao.Impl;

import com.Bean.Record;
import com.Dao.RecordDao;
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
import java.util.List;

@Repository
public class RecordDaoImpl implements RecordDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    private void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public Long count() {
        return jdbcTemplate.query("select count(rId) from record",(rs, rowNum) -> {
            return rs.getLong(1);
        }).get(0);
    }


    @Override
    public Record[] query(Long bId) {
        List<Record> records = jdbcTemplate.query("select * from record where bId=?",
                (rs, rowNum) -> {
                    return setRecord(rs);
                }, bId);
        return records.toArray(new Record[records.size()]);
    }

    @Override
    public Record[] queryAll() {
        List<Record> records = jdbcTemplate.query("select * from records", (rs, rowNum) -> {
            return setRecord(rs);
        });
        return records.toArray(new Record[records.size()]);
    }

    @Override
    public Record[] queryLimit(Long bId, Integer start, Integer pageNum) {
        List<Record> records = jdbcTemplate.query("select * from record where bId=? limit ?,?", (rs, rowNum) -> {
            return setRecord(rs);
        }, bId, start, pageNum);
        return records.toArray(new Record[records.size()]);
    }

    @Override
    public Record[] queryLimit(Integer start, Integer pageNum) {
        List<Record> records = jdbcTemplate.query("select * from record limit ?,?", (rs, rowNum) -> {
            return setRecord(rs);
        },start, pageNum);
        return records.toArray(new Record[records.size()]);
    }

    @Override
    public Record addRecord(Record record) {
        String sql = "insert into user values(rId,?,?,now())";
        // 使用回调机制返回新添加的数据的自增列值，这里是返回uId
        KeyHolder kh = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setLong(1, record.getbId());
            ps.setInt(2, record.getNum());
            return ps;
        }, kh);
        Long key = kh.getKey().longValue();
        record.setrId(key);
        return record;
    }

    private Record setRecord(ResultSet rs) throws SQLException {
        Record record = new Record();
        record.setrId(rs.getLong(1));
        record.setbId(rs.getLong(2));
        record.setNum(rs.getInt(3));
        record.setDateTime(rs.getTimestamp(4));
        return record;
    }
}
