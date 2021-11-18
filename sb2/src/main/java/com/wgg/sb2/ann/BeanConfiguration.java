package com.wgg.sb2.ann;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean("car")
    Toy getCar(){
        return new Car();
    }
}
