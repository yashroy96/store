package com.codewithyash.store.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("/a")
    public String index(){
        return "index.html";
    }
}
