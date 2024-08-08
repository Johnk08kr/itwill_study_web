package com.itwill.springboot5.web;

import com.itwill.springboot5.domain.Member;
import com.itwill.springboot5.dto.MemberSignupDto;
import com.itwill.springboot5.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/signin")
    // SecurityConfig.securityFilterChain 메소드에서 formLogin() 설정한 요청 주소.
    public void signin() {
        log.info("GET signin()");

    }

    @GetMapping("/signup")
    public void signup() {
        log.info("GET signup()");
    }

    @PostMapping("/signup")
    public String signup(MemberSignupDto dto) {
        log.info("signupDto{}", dto);

        //TODO: 서비스 계층의 메소드를 호출해서 회원가입 정보들을 DB에 insert
        Member member = memberService.create(dto);
        return "redirect:/member/signin";
    }
}
