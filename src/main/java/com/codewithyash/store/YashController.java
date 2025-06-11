package com.codewithyash.store;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
@RequestMapping("/yash")
public class YashController {

    @GetMapping("/roy")
    public String index(){
        System.out.println("DEBUG: /yash/roy endpoint hit");
        return "redirect:/index.html";
    }
}