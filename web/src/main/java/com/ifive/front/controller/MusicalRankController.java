package com.ifive.front.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ifive.front.dto.MusicalRankDTO;
import com.ifive.front.service.MusicalRankService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MusicalRankController {
    
    @Autowired
    private MusicalRankService musicalRankService;

    @Autowired
    public MusicalRankController(MusicalRankService musicalRankService) {
        this.musicalRankService = musicalRankService;
    }  

    @GetMapping("/rank")
    public String rankShow(Model model){
        // log.info("무슨 사이트 조회? : " + siteName);
        LocalDate today = LocalDate.now();
        log.info("오늘 날짜 : "+today);

        List<MusicalRankDTO> mrd1 = musicalRankService.getMusicalRankListByUpdateDateSiteName(today.toString()
        ,"인터파크");
        List<MusicalRankDTO> mrd2 = musicalRankService.getMusicalRankListByUpdateDateSiteName(today.toString()
        ,"티켓링크");
        List<MusicalRankDTO> mrd3 = musicalRankService.getMusicalRankListByUpdateDateSiteName(today.toString()
        ,"예스24티켓");
        
        log.info("DTO란 이런 것이다1 : " + mrd1);
        log.info("DTO란 이런 것이다2 : " + mrd2);
        log.info("DTO란 이런 것이다3 : " + mrd3);
        log.info("DTO 크기 : "+mrd1.size());

        // List<MusicalRankDTO> interparkMrd = new List<MusicalRankDTO>();
        model.addAttribute("interparkList", mrd1);
        model.addAttribute("ticketlinkList", mrd2);
        model.addAttribute("yes24ticketList", mrd3);

        return "/basic/rank.html";
    }
}
