package com.jpaBack.MuBind.domain.user;

import com.jpaBack.MuBind.domain.posts.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// 유저 엔티티
@Getter
@NoArgsConstructor
@Entity
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column
    private String picture;

    @Column
    private String genre;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    //유저 정보 엔티티
    @Builder
    public User(String name, String email, String picture, Role role, String genre) {
        this.name = name;
        this.email = email;
        this.picture = picture;
        this.role = role;
        this.genre = genre;
    }

    //유저 정보 수정
    public User update(String name, String picture, String genre) {
        this.name = name;
        this.picture = picture;
        this.genre = genre;

        return this;
    }

    // 유저 권한 받아오기
    public String getRoleKey() {
        return this.role.getKey();
    }
}

