package com.wgg.sb2.ioc.xml;

import org.springframework.beans.factory.annotation.Autowired;

public class FruitService {
    @Autowired
    private Fruit fruit;

    public Fruit getFruit() {
        return fruit;
    }

    public void setFruit(Fruit fruit) {
        this.fruit = fruit;
    }

    public String eat(){
        return fruit.getName();
    }
}
