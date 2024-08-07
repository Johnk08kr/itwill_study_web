package com.itwill.springboot5.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.NaturalId;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
// onlyExplicitlyIncluded 속성: @EqualsAndHashCode.Include 애너테이션이 설정된 필드만 사용할 것인지 여부
// callSuper 속성: superclass의 equals(), hashCode() 메소드를 사용할 것인지 여부
@Entity
@Table(name = "MEMBERS")
public class Member extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @EqualsAndHashCode.Include // username 필드를 equals()와 hashcode()를 오버라이드 할 때 사용
    @NaturalId // Unique
    @Basic(optional = false)
    @Column(updatable = false) // update 쿼리 set 절에서 제외
    private String username;

    @Basic(optional = false)
    private String password;

    @Basic(optional = false)
    private String email;

    @Builder.Default // Builder 패턴에서도 null이 아닌 HashSet<> 객체로 초기화 될수 있도록.
    @ToString.Exclude // toString() 메소드에서 제외.
    @ElementCollection(fetch = FetchType.LAZY) // 연관 테이블(member_roles)사용.
    @Enumerated(EnumType.STRING) // DB 테이블에 저장될 때 상수(enum) 이름(문자열)을 사용
    private Set<MemberRole> roles = new HashSet<>();

    public Member addRole(MemberRole role) {
        roles.add(role);
        return this;
    }

    public Member removeRole(MemberRole role) {
        roles.remove(role); // set<>에서 원소(role)를 삭제
        return this;
    }

    public Member clearRoles() {
        roles.clear(); // set<>의 모든 원소를 지움
        return this;
    }
}
