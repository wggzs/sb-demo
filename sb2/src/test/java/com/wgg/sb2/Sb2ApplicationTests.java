package com.wgg.sb2;

import com.wgg.sb2.ann.ToyService;
import com.wgg.sb2.ioc.xml.*;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
/*@ContextConfiguration(locations = "classpath:ioc/demo.xml")*/
class Sb2ApplicationTests {

    /*@Autowired
    private FruitService fruitService;

    @Autowired
    private AnimalService animalService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private HelloService helloService;*/

    @Autowired
    private ToyService toyService;

    @Test
    void contextLoads() {
    }

    /*@Test
    public void teach(){
        System.out.println(teacherService.teach());
    }

    @Test
    public void hello(){
        System.out.println(helloService.hello());
    }

    @Test
    public void say(){
        System.out.println(animalService.say());
    }


    @Test
    public void eat(){
        System.out.println(fruitService.eat());
    }*/

    @Test
    public void play(){
        System.out.println(toyService.play());
    }
}
