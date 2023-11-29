package com.ifive.front.domain.Member;

import lombok.Getter;

@Getter
public enum MemberRole {
    // 권한을 전부 부여한 이유는, v1.1.0에서는 관리자에 특별한 동작이없어서, 추후에 기능이 생길때 권한분리예정
    ADMIN("ROLE_ADMIN"),
    USER("ROLE_USER");

    MemberRole(String value) {
        this.value = value;
    }

    private String value;
}
