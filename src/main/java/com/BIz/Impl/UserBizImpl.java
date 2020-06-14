package com.BIz.Impl;

import com.BIz.UserBiz;
import com.Bean.User;
import com.Dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserBizImpl  implements UserBiz {


    @Autowired
    UserDao userdao;

    @Override
    @Transactional
    public User inserUser(User user) {
        User u = userdao.addUser(user);
        return u;
    }

    @Override
    public Boolean isUser(String uEmail) {
        return userdao.query(uEmail);
    }

    @Override
    public User login(User user) {
        User u = userdao.loginByEmail(user.getuEmail());
        if (u == null || !u.getuPwd().equals( user.getuPwd())){
            return null;
        }
        return u;
    }
}
