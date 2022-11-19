package com.jpaBack.MuBind.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

//유저 권한 설정
@Getter
@RequiredArgsConstructor
public enum Role {

    GUEST("ROLE_GUEST", "손님"),
    USER("ROLE_USER", "일반 사용자");

    private final String key;
    private final String title;

}