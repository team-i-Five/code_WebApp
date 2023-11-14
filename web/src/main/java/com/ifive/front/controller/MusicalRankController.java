package com.ifive.front.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ifive.front.dto.MusicalRankDTO;
import com.ifive.front.service.MusicalRankService;

import org.springframework.ui.Model;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MusicalRankController {
    
    @Autowired
    private MusicalRankService musicalRankService;

    @GetMapping("/test/rank/{siteName}")
    public String rankShow(@PathVariable String siteName, Model mode){
        log.info("무슨 사이트 조회? : ",siteName);

        List<MusicalRankDTO> mrd = musicalRankService.getMusicalRankListBySiteName(siteName);
        log.info("DTO란 이런 것이다 : ", mrd);

        return "good";
    }
}
