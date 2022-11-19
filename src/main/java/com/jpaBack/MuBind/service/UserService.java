package com.jpaBack.MuBind.service;

import com.jpaBack.MuBind.domain.posts.Posts;
import com.jpaBack.MuBind.domain.user.User;
import com.jpaBack.MuBind.repository.UserRepository;
import com.jpaBack.MuBind.web.dto.post.PostsResponseDto;
import com.jpaBack.MuBind.web.dto.post.PostsUpdateRequestDto;
import com.jpaBack.MuBind.web.dto.user.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// 유저 프로필 리포지토리
@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    //id로 조회하기
    @Transactional(readOnly = true)
    public UserResponseDto findById(Long id) {
        User entity = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        return new UserResponseDto(entity);
    }

    //유저 프로필 수정
    @Transactional
    public Long update(Long id, UserResponseDto responseDto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        user.update(responseDto.getName(), responseDto.getImgUrl(), responseDto.getGenre());

        return id;
    }
}
