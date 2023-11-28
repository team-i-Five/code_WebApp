package com.ifive.front.global.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ifive.front.domain.Past.MusicalPastDTO;
import com.ifive.front.domain.Past.MusicalPastServiceImpl;

import lombok.extern.slf4j.Slf4j;

// 뷰와 연결하는 컨트롤러
@Slf4j
@RequestMapping("/search")
@Controller
public class SearchController {
    @Autowired
    private MusicalPastServiceImpl musicalPastServiceImpl;

    
    public SearchController(MusicalPastServiceImpl musicalPastServiceImpl){
        this.musicalPastServiceImpl = musicalPastServiceImpl;
    }

    // 두번째 선택지
    @GetMapping("/")
    public String searchList(Model model) {
        List<MusicalPastDTO> mpdl = musicalPastServiceImpl.getMusicalPastListOrderByEndDate(25);

        model.addAttribute("musicals", mpdl);
        return "basic/search";
    }

    @GetMapping("/bar")
    public String search(Model model) {
        List<MusicalPastDTO> mpdl = musicalPastServiceImpl.getMusicalPastListOrderByEndDate(25);

        model.addAttribute("musicals", mpdl);
        return "basic/search";
    }
}

