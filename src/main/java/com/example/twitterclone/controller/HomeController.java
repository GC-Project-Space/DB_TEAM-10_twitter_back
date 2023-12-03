package com.example.twitterclone.controller;

import com.example.twitterclone.domain.Post;
import com.example.twitterclone.dto.HomeResponse;
import com.example.twitterclone.service.HomeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j // log 사용을 위한 lombok 어노테이션
@RequiredArgsConstructor // final이 선언된 모든 필드를 인자값으로 하는 생성자를 생성
@RestController // 결과값을 JSON으로 출력
@RequestMapping("/home")
public class HomeController {
    private final HomeService homeService;

    @GetMapping("")
    public ResponseEntity<List<HomeResponse.homeDto>> getLatestPosts() {
        List<HomeResponse.homeDto> latestPosts = homeService.getLatestPosts();
        return ResponseEntity.ok(latestPosts);
    }
}
