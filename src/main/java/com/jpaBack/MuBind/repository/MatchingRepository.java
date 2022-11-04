package com.jpaBack.MuBind.repository;

import com.jpaBack.MuBind.domain.Matching;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class MatchingRepository {

    private final EntityManager em;

    public void save(Matching matching){
        em.persist(matching);
    }
    public Matching findOne(Long id){
        return em.find(Matching.class, id);
    }
}
