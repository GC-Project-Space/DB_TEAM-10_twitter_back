package com.example.twitterclone.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class UserRequest {
    @Getter
    public static class SignUpDto {
        private String name;
        private String loginId;
        private String password;
    }

    @Getter
    public static class pwChangeDto{
        private Long userId;
        private String password;
    }
}
