package com.example.twitterclone.controller;

import com.example.twitterclone.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j // log 사용을 위한 lombok 어노테이션
@RequiredArgsConstructor // final이 선언된 모든 필드를 인자값으로 하는 생성자를 생성
@RestController // 결과값을 JSON으로 출력
@RequestMapping("/follow")
public class FollowController {
    private final MemberService memberService;

    @PostMapping("/{follower-id}/follow/{following-id}")
    public ResponseEntity<String> followMember(@PathVariable("follower-id") Long followerId , @PathVariable("following-id") Long followingId) {
        memberService.followMember(followerId, followingId);
        return ResponseEntity.ok("Successfully followed the member!");
    }
}
