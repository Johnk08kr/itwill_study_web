package com.itwill.springboot5.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.itwill.springboot5.domain.Member;
import com.itwill.springboot5.domain.MemberRole;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Slf4j
@SpringBootTest
public class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepo;

    @Autowired
    private PasswordEncoder pwEncoder;

    //    @Test
    public void testDependencyInjection() {
        assertThat(memberRepo).isNotNull();
        log.info(memberRepo.toString());

        assertThat(pwEncoder).isNotNull();
        log.info(pwEncoder.toString());
    }

    //    @Test
    public void testSave() {
        // 엔터티 객체를 DB members 테이블에 저장.

        Member member1 = Member.builder().username("test3").password(pwEncoder.encode("0410")).email("test3@gmail.com").build();

        member1.addRole(MemberRole.ADMIN);
        log.info("save 호출 전 = {}, {}", member1, member1.getRoles());

        member1 = memberRepo.save(member1);
        log.info("save 호출 후 = {}, {}", member1, member1.getRoles());
    }

    @Test
    @Transactional
    public void testFindAll() {
        List<Member> members = memberRepo.findAll();
        assertThat(members).isNotNull();
        members.forEach(member -> log.info("{}, {}", member, member.getRoles()));
    }
}
