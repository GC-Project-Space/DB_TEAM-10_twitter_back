package com.example.twitterclone.dto;

import com.example.twitterclone.domain.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

public class HomeResponse {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class homeDto {
        private Long postId;
        private String content;
        private Long authorId;
        private LocalDateTime createdAt;

    }
}
