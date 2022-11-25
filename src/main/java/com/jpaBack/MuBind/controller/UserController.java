package com.jpaBack.MuBind.controller;

import com.jpaBack.MuBind.service.UserService;
import com.jpaBack.MuBind.web.dto.post.PostsResponseDto;
import com.jpaBack.MuBind.web.dto.post.PostsUpdateRequestDto;
import com.jpaBack.MuBind.web.dto.user.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

//유저 프로필 컨트롤러
@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    //유저 프로필 조회
    @GetMapping("/user/{id}")
    public UserResponseDto findById(@PathVariable Long id) {

        return userService.findById(id);
    }

    //유저 프로필 업데이트(장르 넣게 해놓음)
    @PutMapping("/user/{id}")
    public Long update(@PathVariable Long id, @RequestBody UserResponseDto responseDto) {
        return userService.update(id, responseDto);
    }
}
