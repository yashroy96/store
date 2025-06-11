package com.codewithyash.store.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewithyash.store.entities.Message;

@RestController
public class MessageController {
    @RequestMapping("/message-from-message-controller")
    public Message sayHello() {
        return Message.builder().name("Yash")
                .age(25)
                .build();
    }
}
