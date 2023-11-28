package com.ifive.front.domain.Member;

import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/member")
public class IfiveMemberController {

    private final IfiveMemberServiceImpl memberService;
   

    @GetMapping("/signup") // Get으로 signup url이 요청되면 회원가입 템플릿을 렌더링
    public String signup(MemberCreateForm memberCreateForm) {
        return "basic/signup_form";
    }

    @PostMapping("/signup") // Post로 요청시 회원가입 진행 , @Valid는 유효성 검사를 위해서 사용함.
    public String signup(@Valid MemberCreateForm memberCreateForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "basic/signup_form";
        }

        // bindingResult.rejectValue(필드명, 오류코드, 에러메시지)
        if (!memberCreateForm.getPassword1().equals(memberCreateForm.getPassword2())) {
            bindingResult.rejectValue("password2", "passwordInCorrect",
                    "패스워드가 일치하지 않습니다.");
            return "basic/signup_form";
        }

        memberService.create(
                memberCreateForm.getMemberName(), memberCreateForm.getEmail(), memberCreateForm.getPassword1());

        return "redirect:/";
    }


    @GetMapping("/signin") // Get으로 signup url이 요청되면 회원가입 템플릿을 렌더링
    public String signin() {
        return "basic/signin_form";
    }
}