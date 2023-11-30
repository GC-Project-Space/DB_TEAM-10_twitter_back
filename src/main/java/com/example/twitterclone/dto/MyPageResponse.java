package com.example.twitterclone.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

public class MyPageResponse {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class mypageDto {
        private int followCount;
        private int followerCount;
        private List<PostDTO> posts;
    }

    @Getter
    @Builder
    public static class PostDTO {
        private Long id;
        private String content;
        private Long authorId;
        private LocalDateTime createdAt;

    }
}
