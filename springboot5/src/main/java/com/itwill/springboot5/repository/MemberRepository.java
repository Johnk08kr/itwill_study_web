package com.itwill.springboot5.repository;

import com.itwill.springboot5.domain.Member;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    // select m.*, r.*
    // from members m left join member_roles r on m.id = r.member_id
    // where m.username = ?
    @EntityGraph(attributePaths = "roles")
    Optional<Member> findByUsername(String username);

}




