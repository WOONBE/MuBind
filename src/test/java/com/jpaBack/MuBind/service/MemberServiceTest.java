package com.jpaBack.MuBind.service;

import com.jpaBack.MuBind.domain.Member;
import com.jpaBack.MuBind.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberServiceTest {
    @Autowired
    MemberService memberService;

    @Autowired
    MemberRepository memberRepository;

    @Test
    public void 회원가입() throws Exception{

        Member member = new Member();
        member.setName("kim");

        Long saveId = memberService.join(member);

        assertEquals(member, memberRepository.findOne(saveId));

    }

    @Test
    public void 중복_예외() throws Exception{
        Member member1 = new Member();
        member1.setName("kim");

        Member member2 = new Member();
        member2.setName("kim");

        memberService.join(member1);
        memberService.join(member2);

        fail("예외가 발생해야한다");
    }


}