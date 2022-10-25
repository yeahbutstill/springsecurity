package com.yeahbutstill.springsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/showMyLoginPageOld")
    public String showMyLoginPageOld() {
        return "plain-login";
    }

    @GetMapping("/showMyLoginPage")
    public String showMyLoginPage() {
        return "fancy-login";
    }

    // add request mapping for / access-denied
    @GetMapping("/access-denied")
    public String showAccessDenied() {
        return "access-denied";
    }

}
