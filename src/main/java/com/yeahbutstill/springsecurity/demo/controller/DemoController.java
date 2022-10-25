package com.yeahbutstill.springsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @GetMapping("/")
    public String showHome() {
        return "home";
    }

    // add request mapping for /gssk
    @GetMapping("/gssk")
    public String showGssk() {
        return "gssk";
    }

    // add request mapping for /gamr
    @GetMapping("/gamr")
    public String showGamr() {
        return "gamr";
    }

}
