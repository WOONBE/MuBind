package com.jpaBack.MuBind.service;

import com.jpaBack.MuBind.domain.user.User;
import com.jpaBack.MuBind.repository.MatchingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


// 매칭 서비스
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MatchingService {

    private final MatchingRepository matchingRepository;

    @Transactional
    public List<User> matching(Long id, User user, String genre){
        List<User> matchingUser = matchingRepository.findByGenre(genre);

        return matchingUser;

    }

    public List<User> findMatching(){
        return matchingRepository.findAll();
    }

    public User findOne(Long matchingID){
        return matchingRepository.findOne(matchingID);
    }

    @Transactional
    public void updateMatching(Long id, String name, String genre){
        User user = (User) matchingRepository.findByGenre(genre);
        user.getId();
        user.getPicture();
        user.getEmail();

    }




}
