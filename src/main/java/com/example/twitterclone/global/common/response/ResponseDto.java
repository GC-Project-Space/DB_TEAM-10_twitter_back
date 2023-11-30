package com.example.twitterclone.global.common.response;

import com.example.twitterclone.global.error.exception.ErrorCode;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonPropertyOrder({"isSuccess", "code", "message", "result"})
public class ResponseDto<T>{

    @JsonProperty("isSuccess")
    private final boolean success;
    private final String code;
    private final String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T result; // 성공시 응답 데이터

    // 성공한 경우 응답 생성
    public static <T> ResponseDto<T> onSuccess(T result){
        return new ResponseDto<>(true, ErrorCode._OK.getCode(), ErrorCode._OK.getMessage(), result);
    }
    // 실패한 경우 응답 생성
    public static <T> ResponseDto<T> onFail(T result, ErrorCode code){
        return new ResponseDto<>(false, code.getCode(), code.getMessage(), result);
    }

}
