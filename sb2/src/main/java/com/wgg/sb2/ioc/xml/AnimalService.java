package com.wgg.sb2.ioc.xml;

import org.springframework.beans.factory.annotation.Autowired;

public class AnimalService {

    @Autowired
    private Animal animal;

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public String say(){
        return animal.getName();
    }
}
