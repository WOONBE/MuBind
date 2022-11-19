package com.jpaBack.MuBind.controller;

import com.jpaBack.MuBind.service.PostsService;
import com.jpaBack.MuBind.web.dto.post.PostsListResponseDto;
import com.jpaBack.MuBind.web.dto.post.PostsResponseDto;
import com.jpaBack.MuBind.web.dto.post.PostsSaveRequestDto;
import com.jpaBack.MuBind.web.dto.post.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// 게시판 api 컨트롤러
@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    //게시판 글 저장
    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    //게시판 글 수정
    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    //게시판 글 삭제
    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id) {
        postsService.delete(id);
        return id;
    }

    //게시판에서 id로 찾기
    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id) {
        return postsService.findById(id);
    }

    //게시판 전체 글 조회
    @GetMapping("/api/v1/posts/list")
    public List<PostsListResponseDto> findAll() {
        return postsService.findAllDesc();
    }
}