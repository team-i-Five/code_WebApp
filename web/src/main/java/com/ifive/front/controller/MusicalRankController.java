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

    // 각 사이트 별로 GetMapping 개설
    @GetMapping("/rank")
    public String interparkRank(Model model){
        LocalDate today = LocalDate.now();
        log.info("오늘 날짜 : "+today);

        List<MusicalRankDTO> mrd = musicalRankService.getMusicalRankListByUpdateDateSiteName(today.toString()
        ,"인터파크");
        
        model.addAttribute("today", today);
        model.addAttribute("interparkList", mrd);

        return "/rankPage/rank_interpark.html";
    }
        
    @GetMapping("/rank/1")
    public String ticketlinkRank(Model model){
        LocalDate today = LocalDate.now();
        log.info("오늘 날짜 : "+today);

        List<MusicalRankDTO> mrd = musicalRankService.getMusicalRankListByUpdateDateSiteName(today.toString()
        ,"티켓링크");

        model.addAttribute("today", today);
        model.addAttribute("ticketlinkList", mrd);

        return "/rankPage/rank_ticketlink.html";
    }
        
    @GetMapping("/rank/2")
    public String yes24ticketRank(Model model){
        LocalDate today = LocalDate.now();
        log.info("오늘 날짜 : "+today);

        List<MusicalRankDTO> mrd = musicalRankService.getMusicalRankListByUpdateDateSiteName(today.toString()
        ,"예스24티켓");
        
        model.addAttribute("today", today);
        model.addAttribute("yes24ticketList", mrd);

        return "/rankPage/rank_yes24ticket.html";
    }
}
