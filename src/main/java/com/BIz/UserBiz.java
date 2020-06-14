package com.BIz;

import com.Bean.User;

public interface UserBiz {

    User inserUser(User user);

    Boolean isUser(String uEmail);

    User login(User user);

}
