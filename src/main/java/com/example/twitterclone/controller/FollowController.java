package com.example.twitterclone.controller;

import com.example.twitterclone.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/follow")
public class FollowController {
    private final MemberService memberService;

    public FollowController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/{followerId}/follow/{followingId}")
    public ResponseEntity<String> followMember(@PathVariable Long followerId, @PathVariable Long followingId) {
        memberService.followMember(followerId, followingId);
        return ResponseEntity.ok("Successfully followed the member!");
    }
}
