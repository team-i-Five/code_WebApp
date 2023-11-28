package com.ifive.front.global.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ifive.front.domain.Future.MusicalFutureDTO;
import com.ifive.front.domain.Future.MusicalFutureService;
import com.ifive.front.domain.Present.MusicalPresentDTO;
import com.ifive.front.domain.Present.MusicalPresentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/result/")
public class ResultController {
    @Autowired
    private MusicalPresentService musicalPresentService;
    @Autowired
    private MusicalFutureService musicalFutureService;

    @Autowired
    public ResultController(MusicalPresentService musicalPresentService
    ,MusicalFutureService musicalFutureService){
        this.musicalPresentService=musicalPresentService;
        this.musicalFutureService=musicalFutureService;
    }

    @GetMapping("ml/{id}")
    public String getRecommends(@PathVariable(name="id") String id
    ,RedirectAttributes redirectAttributes){
        List<MusicalPresentDTO> musicalPresents = musicalPresentService.getPresentDTOsbyIdFromML(id);

        List<MusicalFutureDTO> musicalFutures = musicalFutureService.getFutureDTOsbyIdFromML(id);

        log.info("현재 뮤지컬 추천 : "+musicalPresents);
        log.info("미래 뮤지컬 추천 : "+musicalFutures);

        return "good";
    }

    @GetMapping("/recommends")
    public String showRecommends(Model model){
        
        return "basic/result";
    }
}
