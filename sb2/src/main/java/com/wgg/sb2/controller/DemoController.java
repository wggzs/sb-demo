package com.wgg.sb2.controller;

import com.wgg.sb2.bean.Demo;
import com.wgg.sb2.service.DemoService;
import com.wgg.sb2.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private DemoService demoService;

    @Autowired
    private TestService testService;

    @RequestMapping("/hello/{id}")
    @ResponseBody
    public String hello(@PathVariable(value = "id") Integer id) {
        return Optional.ofNullable(demoService.getDemoById(id)).map(Demo::toString).orElse("empty string");
    }

    @RequestMapping("/test")
    @ResponseBody
    public String test() {
        return testService.test();
    }
}
