package com.ifive.front.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


import lombok.extern.slf4j.Slf4j;

// 뷰와 연결하는 컨트롤러
@Slf4j
@Controller
public class FrontController {

    // // tagName 맵을 클래스 변수로 선언
    // private static final Map<String, String> tagName = new HashMap<>();

    // // 클래스 변수를 정적 블록에서 초기화
    // static {
    //     tagName.put("love", "사랑");
    //     tagName.put("opera", "오페라");
    //     tagName.put("child", "가족");
    //     tagName.put("friend", "친구");
    //     tagName.put("art", "예술");
    //     tagName.put("magic", "판타지");
    //     tagName.put("person", "휴머니즘");
    //     tagName.put("history", "역사");
    //     tagName.put("fear", "공포");
    //     tagName.put("laugh", "코미디");
    //     tagName.put("sad", "슬픔");
    // }
    
    @GetMapping("/")
    public String drawHome(Model model) {
        log.info("log message : {} start", "home(index.html)");
        return "index";
    }

    // 처음 모든 태그 리스트 값 출력된 페이지 이동
    @GetMapping("/tags")
    public String tagList() {
        return "tag/init_tag.html";
    }

    // 태그1 값이 전달된 웹 페이지로 이동
    // @GetMapping("/tags/tag2")
    // public String tagListTag2(@RequestParam(name = "tag1") String tag1, Model model) {
    //     log.info("태그1: " + tag1);

    //     model.addAttribute("tag1", tag1);
    //     model.addAttribute("tagName", tagName.get(tag1));
            
    //     return "tag/selected_tag1";
    // }

    // 태그1, 태그2 값이 전달된 웹 페이지로 이동
    // @GetMapping("/tags/tag3")
    // public String tagListTag3(@RequestParam(name = "tag1") String tag1, 
    // @RequestParam(name = "tag2") String tag2 ,Model model) {
        
    //     log.info("태그1: " + tag1);
    //     log.info("태그2: " + tag2);

    //     model.addAttribute("tag1", tag1);
    //     model.addAttribute("tag2", tag2);
    //     model.addAttribute("tagName1", tagName.get(tag1));
    //     model.addAttribute("tagName2", tagName.get(tag2));
    
    //     return "tag/selected_tag1and2";
    // }
}