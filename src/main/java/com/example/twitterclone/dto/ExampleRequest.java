package com.example.twitterclone.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

//역할 설명 : 예시를 위한 dto
//dto : data transfer object
//dto는 계층간 데이터 교환을 위한 객체(자바빈)를 이야기함
public class ExampleRequest {

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ExampleCreateDto {
        private String massage;
    }
}
