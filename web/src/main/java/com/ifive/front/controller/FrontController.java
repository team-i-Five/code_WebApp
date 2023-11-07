package com.ifive.front.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


// 뷰와 연결하는 컨트롤러
@Controller
public class FrontController {
    private final Logger log = LoggerFactory.getLogger(FrontController.class);
    
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

    @GetMapping("/")
    public String drawHome(Model model) {
        log.info("log message : {} start","home(index.html)");

        return "index";
    }
}
