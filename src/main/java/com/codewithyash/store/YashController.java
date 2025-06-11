package com.codewithyash.store;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//@RequestMapping("/yash")
//public class YashController {
//
//    @Value("${app.myname}")
//    private String name;
//
//    @RequestMapping("/name")
//    public String getHome(){
//        var hgfhfh = ResponseEntity.ok().build();
//        return "Hello World from: Adhi "+ name;
//    }
//    @RequestMapping("/")
//    public String index(){
//        return "index.html";
//    }
//}

@Controller
//@RequestMapping("/yash")
public class YashController {
    @RequestMapping("/yash")
    public String index(){
        return "index.html";
    }
}