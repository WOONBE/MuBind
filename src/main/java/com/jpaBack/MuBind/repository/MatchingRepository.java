package com.jpaBack.MuBind.repository;

import com.jpaBack.MuBind.domain.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MatchingRepository {

    private final EntityManager em;

    public void save(User user){
        em.persist(user);
    }
    public User findOne(Long id){
        return em.find(User.class, id);
    }


    public List<User> findAll(){
        return em.createQuery("select u from User u",User.class)
                .getResultList();
    }



    public List<User> findByGenre(String genre){
        return em.createQuery("select u from User u where u.genre = :genre", User.class)
                .setParameter("genre", genre)
                .getResultList();
    }


}
