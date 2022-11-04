package com.jpaBack.MuBind.service;

import com.jpaBack.MuBind.domain.Matching;
import com.jpaBack.MuBind.domain.Member;
import com.jpaBack.MuBind.repository.MatchingRepository;
import com.jpaBack.MuBind.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MatchingService {
    private final MemberRepository memberRepository;
    private final MatchingRepository matchingRepository;

    @Transactional
    public Long matching(Long memberId, Long matchingId){
        Member member = memberRepository.findOne(memberId);
        Matching matching = matchingRepository.findOne(matchingId);

        return null;
    }
    @Transactional
    public void cancelMatching(Long matchingId){

        Matching matching = matchingRepository.findOne(matchingId);

        matching.cancel();
    }

}
