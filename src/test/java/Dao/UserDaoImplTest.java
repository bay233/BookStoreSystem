package Dao;

import com.Bean.User;
import com.Config.AppConfig;
import com.Dao.Impl.UserDaoImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;

@RunWith(SpringJUnit4ClassRunner.class)   // 请导入    spring-test包
@ContextConfiguration(classes = {AppConfig.class})    //IOC
public class UserDaoImplTest {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    private void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Autowired
    private UserDaoImpl udi;

    @Test
    public void isUDIobejct(){
        assert udi != null;
        System.out.println(udi);
    }

    @Test
    public void queryUser(){
        assert udi.query(1L) != null;
        System.out.println(udi.query(1L));
    }

    @Test
    public void queryAll(){
        User[] users = udi.queryAll();
        assert users != null;
        System.out.println(users);
    }

    @Test
    public void addUser(){
        User user = new User("baijiahui233@163.com","a","bay2");
        User u = udi.addUser(user);
        assert u.getuId() == 2L;
        System.out.println(u);
    }

    @Test
    public void queryLimit(){
        User u = new User();
        u.setuPwd("a");
        User[] users = udi.queryLimit(u, 0, 2);
        assert users.length == 2;
        System.out.println(users.toString());
    }
}
