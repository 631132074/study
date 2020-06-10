package com.bwl.study.controller;

import org.springframework.web.bind.annotation.*;

/**
 * @author BW Li
 * @date 2020-05-21 11:50
 * @description
 */
@RestController
@RequestMapping(value = "/api")
public class HelloWorld {

    @PostMapping("/HelloWorld")
    public String HelloWorld( ){
        return "HelloWorld";
    }

}
