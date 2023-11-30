package com.example.twitterclone.controller;

import com.example.twitterclone.dto.MyPageResponse;
import com.example.twitterclone.service.MemberService;
import com.example.twitterclone.service.MyPageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/mypage")
public class MyPageController {
    private final MyPageService myPageService;

    public MyPageController(MyPageService myPageService) {
        this.myPageService = myPageService;
    }

    @GetMapping("/{memberId}")
    public ResponseEntity<MyPageResponse.mypageDto> getMyPageInfo(@PathVariable Long memberId,
                                                   @RequestParam(defaultValue = "0") int page,
                                                   @RequestParam(defaultValue = "20") int size) {
        MyPageResponse.mypageDto myPageDTO = myPageService.getMyPageInfo(memberId, page, size);
        return ResponseEntity.ok(myPageDTO);
    }
}
