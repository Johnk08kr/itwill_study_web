package com.itwill.springboot5.domain;

public enum MemberRole {
    USER("ROLE_USER"),
    ADMIN("ROLE_ADMIN");

    private String authority;

    // [private] enum의 생성자는 항상 private.
    MemberRole(String authority) {
        this.authority = authority;
    }

    public String getAuthority() {
        return this.authority;
    }
}
