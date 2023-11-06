package com.ifive.front.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.Data;

import org.springframework.ui.Model;


// 타임리프 스터디용 컨트롤러
@Controller
public class StudyController {
    

    // 타임리프 문법
    @GetMapping("/study")
    public String test_addData(Model model) {
        
        //출력예제
        model.addAttribute("data", "데이터출력");
        model.addAttribute("data2", "<br>내부 html포함한 데이터출력<br>");
        

        //SpringEL 표현식예제 List, Obj, map 다루는방법
        User userA = new User("userA", 10);
        User userB = new User("userB", 20);

        List<User> list = new ArrayList<>(Arrays.asList(userA, userB));

        Map<String, User> map = new HashMap<>();
        map.put("userA", userA);
        map.put("userB", userB);

        model.addAttribute("user", userA);
        model.addAttribute("users", list);
        model.addAttribute("userMap", map);
        return "basic/study";
    }

    // 
    /* @Data 설명
        모든 필드에 대한 getters 메서드 생성.
        모든 non-final 필드에 대한 setters 메서드 생성.
        equals, hashCode, toString, @EqualsAndHashCode, @ToString, @RequiredArgsConstructor 애노테이션 자동 추가.
     */
    @Data
    static class User{
        private String username;
        private int age;

        public User(String username, int age) {
            this.username = username;
            this.age = age;
        }
    }
}
