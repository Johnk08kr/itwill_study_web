package com.itwill.springboot5.dto;

import com.itwill.springboot5.domain.Member;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
public class MemberSignupDto {

    private String username;
    private String password;
    private String email;

    public Member toEntity(PasswordEncoder encoder) {
        return Member.builder()
                .username(username)
                .password(encoder.encode(password))
                .email(email)
                .build();
    }
}
