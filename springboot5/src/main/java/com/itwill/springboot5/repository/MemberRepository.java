package com.itwill.springboot5.repository;

import com.itwill.springboot5.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
