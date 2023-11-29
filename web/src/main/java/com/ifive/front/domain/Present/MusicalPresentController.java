package com.ifive.front.domain.Present;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/present")
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
    public String drawPresent(@PathVariable(name = "id") String id
    ,@RequestParam(name = "title") String title
    ,Model model) {
        List<MusicalPresentDTO> mpdl = musicalPresentService.getPresentDTOsbyIdFromML(id);
        log.info("mpdl = {}",mpdl.toString());
        model.addAttribute("musicals", mpdl);
        model.addAttribute("selectedTitle", title);
        model.addAttribute("tag1", null);
        model.addAttribute("tag2", null);
        model.addAttribute("slideNum", '1');
        model.addAttribute("id", id);

        return "tag/tag_list";
    }
}
