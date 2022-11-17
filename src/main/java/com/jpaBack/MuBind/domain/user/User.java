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

    @Builder
    public User(String name, String email, String picture, Role role, String genre) {
        this.name = name;
        this.email = email;
        this.picture = picture;
        this.role = role;
        this.genre = genre;
    }

    public User update(String name, String picture, String genre) {
        this.name = name;
        this.picture = picture;
        this.genre = genre;

        return this;
    }

    public String getRoleKey() {
        return this.role.getKey();
    }
}

