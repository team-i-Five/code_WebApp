package com.ifive.front.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ifive.front.service.MusicalService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LoginController {
    @Autowired
    private MusicalService musicalService;

    @GetMapping("/login") 
    public String drawAllmusical(Model model) {            
        return "/basic/login";
    }
}