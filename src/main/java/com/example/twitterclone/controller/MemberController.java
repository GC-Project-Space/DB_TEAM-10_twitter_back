package com.example.twitterclone.controller;

import com.example.twitterclone.converter.ExampleConverter;
import com.example.twitterclone.converter.UserConverter;
import com.example.twitterclone.domain.Example;
import com.example.twitterclone.domain.Member;
import com.example.twitterclone.dto.ExampleRequest;
import com.example.twitterclone.dto.ExampleResponse;
import com.example.twitterclone.dto.UserRequest;
import com.example.twitterclone.dto.UserResponse;
import com.example.twitterclone.global.common.response.ResponseDto;
import com.example.twitterclone.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.Fetch;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Slf4j // log 사용을 위한 lombok 어노테이션
@RequiredArgsConstructor // final이 선언된 모든 필드를 인자값으로 하는 생성자를 생성
@RestController // 결과값을 JSON으로 출력
@RequestMapping("/users")
public class MemberController {

    private final MemberService memberService;

    @Operation(summary = "Sign Up API", description = "회원가입 API") // Swagger Operation
    @PostMapping("/sign-up") // http://localhost:8080/example/test
    public ResponseDto<UserResponse.SignUpDto> join(@RequestBody @Valid UserRequest.SignUpDto request) {

        Member member = memberService.signUp(request);

        return ResponseDto.onSuccess(UserConverter.toSignUpDTO(member)); // ResponseDto.onSuccess() : 성공 시 ResponseDto 객체를 생성
    }

    @Operation(summary = "change-password API", description = "비밀번호 변경 API") // Swagger Operation
    @PatchMapping("/{user-id}/change-password")
    public ResponseEntity<String> changePassword(@PathVariable Long userId,
                                                 @RequestBody String newPassword) {
        memberService.changePassword(userId, newPassword);
        return ResponseEntity.ok("Password changed successfully for user: " + userId.toString());
    }



}
