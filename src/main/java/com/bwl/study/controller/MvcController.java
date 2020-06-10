package com.bwl.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author BW Li
 * @date 2020-05-29 19:42
 * @description
 */
@Controller
public class MvcController {
    @GetMapping("/helloMVC")
    public String index(){
        return "index";
    }
}
