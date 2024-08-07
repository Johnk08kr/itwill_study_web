package com.itwill.springboot5.domain;



import com.mysema.commons.lang.Assert;
import lombok.extern.slf4j.Slf4j;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class MemberTest {

//    @Test
    public void testEqualsAndHashCode() {
        Member member1 = Member.builder().id(1L).username("admin").password("1111").email("admin1@q.q").build();
        log.info("member1={}", member1);
        Member member2 = Member.builder().id(1L).username("admin").password("2222").email("admin2@q.q").build();
        log.info("member2={}", member2);

        assertThat(member1).isEqualTo(member2);

    }


}
