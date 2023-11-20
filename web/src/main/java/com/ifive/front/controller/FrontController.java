package com.ifive.front.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

// 뷰와 연결하는 컨트롤러
@Slf4j
@Controller
public class FrontController {
<<<<<<< HEAD
=======

    @RequestMapping(value = "/list/**", method = RequestMethod.GET)
    public String listRequest() {
        return "basic/list";
    }

    @RequestMapping(value = "/review/**", method = RequestMethod.GET)
    public String reviewRequest() {
        return "basic/review";
    }

    @RequestMapping(value = "/login/**", method = RequestMethod.GET)
    public String loginRequest() {
        return "basic/login";
    }

>>>>>>> fc2814550f9e8268b0c854614ff5b9b597e809db
    @GetMapping("/")
    public String drawHome(Model model) {
        log.info("log message : {} start", "home(index.html)");

        return "index";
    }
<<<<<<< HEAD
    
=======

>>>>>>> fc2814550f9e8268b0c854614ff5b9b597e809db
}