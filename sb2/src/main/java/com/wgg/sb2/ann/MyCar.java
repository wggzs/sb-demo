package com.wgg.sb2.ann;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component
public class MyCar implements FactoryBean<Toy> {
    @Override
    public Toy getObject() throws Exception {
        return new Car();
    }

    @Override
    public Class<?> getObjectType() {
        return Toy.class;
    }
}
