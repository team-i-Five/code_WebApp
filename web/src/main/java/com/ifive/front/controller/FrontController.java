package com.ifive.front.controller;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.slf4j.Logger;

import org.springframework.ui.Model;



@Controller
public class FrontController {
    private final Logger log = LoggerFactory.getLogger(FrontController.class);
    

    @GetMapping("/")
    public String drawHome(Model model) {
        log.info("log message : {} start","home(index.html)");

    

        return "index";
    }

    @GetMapping("/list")
    public String drawList(Model model) {
        log.info("log message : {} start","list(list.html)");

    

        return "basic/list";
    }

    @GetMapping("/login")
    public String drawLogin(Model model) {
        log.info("log message : {} start","login(login.html)");

    

        return "basic/login";
    }
}
