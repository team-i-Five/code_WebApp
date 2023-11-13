package com.ifive.front.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ifive.front.entity.Musical;
import com.ifive.front.service.MusicalService;

import lombok.extern.slf4j.Slf4j;

// 뮤지컬 데이터 컨트롤러

@Slf4j
@Controller
public class MusicalController {
    @Autowired
    private MusicalService musicalService;


    
    @GetMapping("/list/filepath")
    public String drawMusicals(Model model) {
        log.info("info log = {}", this.getClass());

        List<Musical> musicalList = musicalService.getMusicalsFromJsonFile("/static/mock.json");
        
        model.addAttribute("musicalList", musicalList);

        return "/basic/list";
    }

    //JSON데이터 DB에 저장하는 메소드
    @GetMapping("/list/save")
    @ResponseBody
    public String saveDBfromJsonFile() {
        log.info("info log = {}", this.getClass());

        try {
            musicalService.saveMusicalFromJson("/static/mock.json");
            return "저장완료";
        } catch (Exception e) {
            log.error("저장실패 : {}", e.getMessage(),e); // 또는 로깅 등으로 예외를 처리
            return "저장 실패: " + e.getMessage();
        }
    }
}
