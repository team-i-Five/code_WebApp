package com.ifive.front.domain.Future;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MusicalFutureController {
    
    @Autowired
    private MusicalFutureService musicalFutureService;

    @Autowired
    public MusicalFutureController(MusicalFutureService musicalFutureService){
        this.musicalFutureService = musicalFutureService;
    }

    @GetMapping("/ml2/{id}")
    public String drawFuture(@PathVariable(name = "id") String id
    ,@RequestParam(name = "title") String title
    ,Model model) {
        List<MusicalFutureDTO> mpdl = musicalFutureService.getFutureDTOsbyIdFromML(id);
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
