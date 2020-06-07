package com.Web.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/bookStore/index*")
    private String toIndex(){
        return "/index.html";
    }
}
