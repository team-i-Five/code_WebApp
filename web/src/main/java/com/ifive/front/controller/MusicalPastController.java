package com.ifive.front.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ifive.front.dto.MusicalPastDTO;
import com.ifive.front.service.MusicalPastService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MusicalPastController {
    
    @Autowired
    private MusicalPastService musicalPastService;

    @Autowired
    public MusicalPastController(MusicalPastService musicalPastService){
        this.musicalPastService = musicalPastService;

    }
    @GetMapping("/past")
    public String pastShow(Model model){
        List<MusicalPastDTO> mpd = musicalPastService.getMusicalPastListOrderByEndDate();
        // log.info("이게 PAST DTO 다 : "+mpd);
        // log.info("이게 크기야 : "+mpd.size());

        model.addAttribute("musicalPastList", mpd);

        return "/basic/past";
    }
}
