package com.ifive.front.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ifive.front.dto.MusicalDTO;
import com.ifive.front.entity.Musical;
import com.ifive.front.service.MusicalService;

import lombok.extern.slf4j.Slf4j;

// 뮤지컬 데이터 컨트롤러

@Slf4j
@Controller
public class MusicalController {
    @Autowired
    private MusicalService musicalService;

    @GetMapping("/list/all")
    public String drawAllmusical(Model model) {            
        model.addAttribute("musicals", musicalService.getAllMusicals());
        return "/basic/list";
    }
    

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
    

    @GetMapping("/list/test")
    @ResponseBody
    public String dbTest(Model model) {
        log.info("log message : {} start", "test.html");
        List<MusicalDTO> musicalDTOs = musicalService.getAllMusicals();
        return musicalDTOs.get(0).toString();
    }

    // @GetMapping("/list/{musicalId}")
    // public String detailMusical(@PathVariable int musicalId, Model model) {
    //     // musicalId를 사용하여 해당 뮤지컬의 정보를 가져옴
    //     MusicalDTO musicalDTO = musicalService.getMusicalById(musicalId);
    
    //     // 가져온 정보를 모델에 추가
    //     model.addAttribute("musical", musicalDTO);
    
    //     // detail.html로 이동
    //     return "/basic/detail";
    // }
}
