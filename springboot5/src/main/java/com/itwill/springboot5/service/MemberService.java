package com.itwill.springboot5.service;

import com.itwill.springboot5.domain.Member;
import com.itwill.springboot5.domain.MemberRole;
import com.itwill.springboot5.dto.MemberSignupDto;
import com.itwill.springboot5.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
// Spring Security에서 로그인/로그아웃 처리에서 사용할 수 있도록
// UserDetailsService
public class MemberService implements UserDetailsService {

    private final MemberRepository memberRepo;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public Member create(MemberSignupDto dto) {
        log.info("create(dto={})", dto);

        Member member = memberRepo.save(dto.toEntity(passwordEncoder)).addRole(MemberRole.USER);
        // save()
        // (1) insert into members
        // (2) insert into member_roles
        return member;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // DB 테이블(members)에 username이 일치하는 사용자가 있으면 UserDetails 타입의 객체를 리턴하고
        // 그렇지 않으면 UsernameNotFoundException을 던짐.
        log.info("loadUserByUsername(username={})", username);
        Optional<Member> member = memberRepo.findByUsername(username);
        if (member.isPresent()) {
            return member.get();
        } else {
            throw new UsernameNotFoundException("Username not found");
        }
    }
}
