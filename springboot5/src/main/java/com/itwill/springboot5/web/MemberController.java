package com.itwill.springboot5.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/member")
public class MemberController {

    @GetMapping("/signin")
    // SecurityConfig.securityFilterChain 메소드에서 formLogin() 설정한 요청 주소.
    public void signin(){
        log.info("GET signin()");
    }

}
