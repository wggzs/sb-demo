package com.wgg.sb2.ioc.xml;

public class FruitFactory {
    public Fruit getFruit(String type){
        if("banana".equals((type))){
            return new Banana();
        }else {
            return new Apple();
        }
    }
}
