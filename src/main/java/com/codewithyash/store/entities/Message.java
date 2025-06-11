package com.codewithyash.store.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@AllArgsConstructor
@Data
@Builder

public class Message {
    private String name;
    
    private int age;

    @Builder.Default
    private boolean old = true;
}
