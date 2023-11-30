package com.example.twitterclone.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class MyPageRequest {

    @Getter
    public static class MyPageDto {
        private Long userId;
    }
}
