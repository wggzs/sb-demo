package com.wgg.sb2.ann;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ToyService {
    @Autowired
    private Toy toy;

    public String play(){
        return toy.getName();
    }
}
