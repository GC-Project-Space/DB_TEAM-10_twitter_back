package com.example.twitterclone.controller;

import com.example.twitterclone.dto.MyPageResponse;
import com.example.twitterclone.service.MemberService;
import com.example.twitterclone.service.MyPageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j // log 사용을 위한 lombok 어노테이션
@RequiredArgsConstructor // final이 선언된 모든 필드를 인자값으로 하는 생성자를 생성
@RestController // 결과값을 JSON으로 출력
@RequestMapping("/mypage")
public class MyPageController {
    private final MyPageService myPageService;

    @GetMapping("/{memberId}")
    public ResponseEntity<MyPageResponse.mypageDto> getMyPageInfo(@PathVariable Long memberId,
                                                   @RequestParam(defaultValue = "0") int page,
                                                   @RequestParam(defaultValue = "20") int size) {
        MyPageResponse.mypageDto myPageDTO = myPageService.getMyPageInfo(memberId, page, size);
        return ResponseEntity.ok(myPageDTO);
    }
}
