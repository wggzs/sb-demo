package com.wgg.sb2.ioc.xml;

public class AnimalFactory {

    public static Animal getAnimal(String type){
        if ("Dog".equals(type)){
            return new Dog();
        } else {
            return new Cat();
        }
    }
}
