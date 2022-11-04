package com.jpaBack.MuBind.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "matchings")
@Getter @Setter
public class Matching {

    @Id
    @GeneratedValue
    @Column(name = "matching_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    private LocalDateTime matchingDate;

    @Enumerated(EnumType.STRING)
    private MatchingStatus status;


    //create matching

    public void cancel() {
        if (getStatus() == MatchingStatus.Complete) {
            throw new IllegalStateException("매칭 완료시 매칭 취소가 불가능합니다.");
        }
    }
}
