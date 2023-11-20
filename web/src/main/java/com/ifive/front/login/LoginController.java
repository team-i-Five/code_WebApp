package com.ifive.front.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;

    @GetMapping("/login") 
    public String drawloginPage() {            
        return "/basic/login";
    }
}