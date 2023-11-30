package com.example.twitterclone.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class FollowRequest {
    @Getter
    public static class followDto {
        private Long userId;
        private Long followId;
    }
}
