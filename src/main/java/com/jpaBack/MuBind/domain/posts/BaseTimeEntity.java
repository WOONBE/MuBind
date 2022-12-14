package com.jpaBack.MuBind.domain.posts;


import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

//현재 시간 조회용
    @Getter
    @MappedSuperclass
    @EntityListeners(AuditingEntityListener.class)
    public abstract class BaseTimeEntity {

        @CreatedDate
        private LocalDateTime createdDate;


        @LastModifiedDate
        private LocalDateTime modifiedDate;

    }



