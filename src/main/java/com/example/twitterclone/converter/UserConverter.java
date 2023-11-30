package com.example.twitterclone.converter;

import com.example.twitterclone.domain.Example;
import com.example.twitterclone.domain.Member;
import com.example.twitterclone.dto.ExampleRequest;
import com.example.twitterclone.dto.UserResponse;
import com.example.twitterclone.global.constant.Status;

public class UserConverter {

    public static UserResponse.SignUpDto toSignUpDTO(
            Member member // ExampleRequest.ExampleCreateDto 객체를 Example 객체로 변환하는 메소드
    ) {
        return UserResponse.SignUpDto.builder()
                .userId(member.getId()) // Example 객체의 massage 필드에 ExampleRequest.ExampleCreateDto 객체의 massage 필드를 저장
                .build(); // Example 객체를 생성
    }
}
