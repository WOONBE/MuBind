package com.jpaBack.MuBind.controller;

import com.jpaBack.MuBind.domain.user.User;
import com.jpaBack.MuBind.service.MatchingService;
import com.jpaBack.MuBind.web.dto.user.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MatchingController {

    private final MatchingService matchingService;


    @GetMapping("/matching/{id}")
    public UserResponseDto findByGenre(@PathVariable Long id, User user, String genre) {
        return (UserResponseDto) matchingService.matching(id, user, genre);
    }

}
