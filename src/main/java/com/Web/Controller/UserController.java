package com.Web.Controller;

import com.BIz.UserBiz;
import com.Bean.User;
import com.Common.Model.JsonModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/bookStore")
public class UserController {

    @Autowired
    private UserBiz userBiz;

    @RequestMapping(value = "/register", method = {RequestMethod.POST})
    private @ResponseBody
    JsonModel register(User user, HttpServletRequest request) {
        JsonModel jm = new JsonModel();
        if (userBiz.isUser(user.getuEmail())) {
            jm.setCode(0);
            return jm;
        }
        User u = userBiz.inserUser(user);
        if (u != null) {
            jm.setCode(1);
            request.getSession(true).setAttribute("user", u);
        }
        return jm;
    }

    @RequestMapping(value = "/login", method = {RequestMethod.POST})
    private @ResponseBody
    JsonModel login(User user, HttpServletRequest request) {
        JsonModel jm = new JsonModel();
        User u = userBiz.login(user);
        if (u == null) {
            jm.setCode(0);
            return jm;
        }
        request.getSession(true).setAttribute("user", u);
        jm.setCode(1);
        return jm;
    }

    @RequestMapping(value = "/logOut", method = {RequestMethod.GET,RequestMethod.POST})
    private @ResponseBody
    JsonModel logOut(HttpServletRequest request) {
        JsonModel jm = new JsonModel();
        Object user = request.getSession().getAttribute("user");
        if (user != null){
            request.getSession().removeAttribute("user");
        }
        jm.setCode(1);
        return jm;
    }



    @RequestMapping(value = "/cacheUser", method = {RequestMethod.GET,RequestMethod.POST})
    private @ResponseBody
    JsonModel cacheUser(HttpServletRequest request) {
        JsonModel jm = new JsonModel();
        Object user = request.getSession().getAttribute("user");
        if (user == null){
            jm.setCode(0);
            return jm;
        }
        ((User) user).setuPwd("");
        jm.setObj(user);
        jm.setCode(1);
        return jm;
    }


}
