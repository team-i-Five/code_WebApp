package com.ifive.front.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ifive.front.dto.MusicalPastDTO;
import com.ifive.front.service.MusicalPastService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MusicalPastController {
    
    // tagName 맵을 클래스 변수로 선언
    private static final Map<String, String> tagName = new HashMap<>();

    // 클래스 변수를 정적 블록에서 초기화
    static {
        tagName.put("love", "사랑");
        tagName.put("opera", "오페라");
        tagName.put("child", "아이");
        tagName.put("friend", "친구");
        tagName.put("art", "예술");
        tagName.put("magic", "마법");
        tagName.put("person", "사람");
        tagName.put("history", "역사");
        tagName.put("fear", "공포");
        tagName.put("laugh", "웃음");
        tagName.put("sad", "슬픔");
    }

    @Autowired
    private MusicalPastService musicalPastService;

    @Autowired
    public MusicalPastController(MusicalPastService musicalPastService){
        this.musicalPastService = musicalPastService;
    }


    @GetMapping("/past")
    public String pastShow(Model model){
        List<MusicalPastDTO> mpd = musicalPastService.getMusicalPastListOrderByEndDate();

        model.addAttribute("musicalPastList", mpd);

        return "/basic/past";
    }

    @GetMapping("/tags/tag1")
    public String sendTag1(@RequestParam(name = "tag1") String tag1, Model model){
        log.info("ㅅㅁㅅㅁㅅ : "+tag1);

        List<MusicalPastDTO> mpdl = musicalPastService.getMusicalPastListByTag1(tagName.get(tag1));
        
        // log.info("쿼리문 결과 DTO : "+mpdl);
        // log.info("쿼리문 결과 개수 : "+mpdl.size());

        model.addAttribute("tag", tag1);
        // model.addAttribute("musicalTag1", mpdl);

        return "redirect:/tags/tag2?tag1="+tag1;
    }

    @GetMapping("/tags/tag1&tag2")
    public String sendTag2(@RequestParam(name = "tag1") String tag1, 
    @RequestParam(name = "tag2") String tag2, Model model){
        
        log.info("태그 1 : "+tag1);
        log.info("태그 2 : "+tag2);

        // List<MusicalPastDTO> mpdl = musicalPastService.getMusicalPastListByTag1AndTag2(tag1, tag2);

        // log.info("쿼리문 결과 DTO : "+mpdl);
        // log.info("쿼리문 결과 개수 : "+mpdl.size());

        model.addAttribute("tag1", tag1);
        model.addAttribute("tag2", tag2);

        return "redirect:/tags/tag3?tag1="+tag1+"&tag2="+tag2;
        
    }

    @GetMapping("/tags/allTagsSelected")
    public String sendAllTags(@RequestParam(name = "tag1") String tag1, 
    @RequestParam(name = "tag2") String tag2, @RequestParam(name = "tag3") String tag3, Model model){
        
        log.info("태그 1 : "+tag1);
        log.info("태그 2 : "+tag2);
        log.info("태그 3 : "+tag3);

        

        List<MusicalPastDTO> mpdl = musicalPastService.getMusicalPastListByAllTags(
                                            tagName.get(tag1),tagName.get(tag2), tagName.get(tag3)
                                        );

        log.info("쿼리문 결과 DTO : "+mpdl);
        log.info("쿼리문 결과 개수 : "+mpdl.size());

        model.addAttribute("tagMusicalList", mpdl);
        // model.addAttribute("tag1", tag1);
        // model.addAttribute("tag2", tag2);
        // model.addAttribute("tag3", tag2);

        return "good" ;
        
    }
}
