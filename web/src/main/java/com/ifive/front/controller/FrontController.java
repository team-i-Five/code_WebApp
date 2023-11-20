package com.ifive.front.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

// 뷰와 연결하는 컨트롤러
@Slf4j
@Controller
public class FrontController {
    @GetMapping("/")
    public String drawHome(Model model) {
        log.info("log message : {} start", "home(index.html)");

        return "index";
    }
}