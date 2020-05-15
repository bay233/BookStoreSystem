package com.Web.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("bookStore")
public class IndexController {

    @GetMapping("/index*")
    private String toIndex(){
        return "/index.html";
    }
}
