package com.example.twitterclone.converter;

import com.example.twitterclone.domain.Example;
import com.example.twitterclone.dto.ExampleRequest;
import com.example.twitterclone.dto.ExampleResponse;
import com.example.twitterclone.global.constant.Status;

public class ExampleConverter {

    public static ExampleResponse.ExampleCreateDto toExampleResponse(
            String massage
    ) {
        return ExampleResponse.ExampleCreateDto.builder()
                .massage("Example 객체 생성에 성공했습니다.")
                .massageInExample(massage)
                .build();
    }

    public static Example toExample(
            ExampleRequest.ExampleCreateDto exampleCreateDto
    ) {
        return Example.builder()
                .massage(exampleCreateDto.getMassage())
                .status(Status.ACTIVE)
                .build();
    }
}
