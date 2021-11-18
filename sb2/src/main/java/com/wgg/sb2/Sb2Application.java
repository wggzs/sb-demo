package com.wgg.sb2;

import com.wgg.sb2.Initializer.SecondInitializer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wgg.sb2.mapper")
public class Sb2Application {

    public static void main(String[] args) {
        SpringApplication.run(Sb2Application.class, args);
    }

}
