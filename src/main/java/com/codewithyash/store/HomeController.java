package com.codewithyash.store;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Value("${app.myname}")
    private String name;

    @RequestMapping("/")
    public String getHome(){
        return "Hello World from: Adhi "+ name;
    }
}
