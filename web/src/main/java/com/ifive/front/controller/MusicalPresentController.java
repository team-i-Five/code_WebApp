package com.ifive.front.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ifive.front.entity.MusicalPresent;
import com.ifive.front.service.MusicalPresentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MusicalPresentController {

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
    private MusicalPresentService musicalPresentService;

    @Autowired
    public MusicalPresentController(MusicalPresentService musicalPresentService) {
        this.musicalPresentService = musicalPresentService;
    }

    @GetMapping("/ml/{id}")
    @ResponseBody
    public String drawPresent(@PathVariable(name = "id") String id, Model model) {
        List<MusicalPresent> musicalPresents = musicalPresentService.getPresentDTOsbyIdFromML(id);

        StringBuilder responseBuilder = new StringBuilder();

        for(MusicalPresent musicalPresent : musicalPresents) {
            responseBuilder.append(musicalPresent.toString()).append("\n");
        }
 
        return responseBuilder.toString();
    }
}
