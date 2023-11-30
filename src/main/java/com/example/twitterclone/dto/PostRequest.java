package com.example.twitterclone.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class PostRequest {

    @Getter
    public static class like {
        private Long userId;
        private Long followId;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class followDto {
        private Long userId;
        private Long followId;
    }
}
