package com.example.twitterclone.converter;

import com.example.twitterclone.domain.Example;
import com.example.twitterclone.dto.ExampleRequest;
import com.example.twitterclone.dto.ExampleResponse;
import com.example.twitterclone.global.constant.Status;

// 역할 설명  : Example 관련 객체를 변환하는 클래스
//객체를 반환해서 사용할 수 있도록 하는 클래스
public class ExampleConverter {

    public static ExampleResponse.ExampleCreateDto toExampleResponse( // ExampleResponse.ExampleCreateDto 객체를 반환하는 메소드
            String massage
    ) {
        return ExampleResponse.ExampleCreateDto.builder() // ExampleResponse.ExampleCreateDto 객체를 생성하는 메소드
                .massage("Example 객체 생성에 성공했습니다.") // massage 필드에 "Example 객체 생성에 성공했습니다."를 저장
                .massageInExample(massage) // massageInExample 필드에 massage를 저장
                .build(); // ExampleResponse.ExampleCreateDto 객체를 생성
    }

    public static Example toExample(
            ExampleRequest.ExampleCreateDto exampleCreateDto // ExampleRequest.ExampleCreateDto 객체를 Example 객체로 변환하는 메소드
    ) {
        return Example.builder()
                .massage(exampleCreateDto.getMassage()) // Example 객체의 massage 필드에 ExampleRequest.ExampleCreateDto 객체의 massage 필드를 저장
                .status(Status.ACTIVE) // Example 객체의 status 필드에 Status.ACTIVE를 저장
                .build(); // Example 객체를 생성
    }
}
