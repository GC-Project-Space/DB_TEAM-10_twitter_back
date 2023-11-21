package com.example.twitterclone.controller;

import com.example.twitterclone.converter.ExampleConverter;
import com.example.twitterclone.domain.Example;
import com.example.twitterclone.dto.ExampleRequest;
import com.example.twitterclone.dto.ExampleResponse;
import com.example.twitterclone.global.common.response.ResponseDto;
import com.example.twitterclone.service.ExampleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Example", description = "예시 API") // Swagger Tag
@Slf4j // log 사용을 위한 lombok 어노테이션
@RequiredArgsConstructor // final이 선언된 모든 필드를 인자값으로 하는 생성자를 생성
@RestController // 결과값을 JSON으로 출력
@RequestMapping("/example") // http://localhost:8080/example
public class ExampleController {

    private final ExampleService exampleService;

    @Operation(summary = "Link Test API", description = "서버 연결 테스트용 API") // Swagger Operation
    @GetMapping("/test") // http://localhost:8080/example/test
    public ResponseDto<String> test() {
        return ResponseDto.onSuccess("Server is running"); // ResponseDto.onSuccess() : 성공 시 ResponseDto 객체를 생성
    }

    @Operation(summary = "Example Create API", description = "예시 생성 API") // Swagger Operation
    @Parameters({ // Swagger Parameter
            @Parameter(name = "massage", description = "예시 메시지", required = true) // Swagger Parameter
    })
    @PostMapping("/create") // http://localhost:8080/example/create
    public ResponseDto<ExampleResponse.ExampleCreateDto> create( // ExampleResponse.ExampleCreateDto 객체를 담은 ResponseDto 객체를 생성
            @RequestBody ExampleRequest.ExampleCreateDto exampleCreateDto // RequestBody : Request의 Body에 담긴 데이터를 자바 객체로 매핑
    ) {
        Example example = exampleService.exampleCreate(exampleCreateDto); // Example 객체 생성
        return ResponseDto.onSuccess(ExampleConverter.toExampleResponse(example.getMassage())); // ResponseDto.onSuccess() : 성공 시 ResponseDto 객체를 생성
    }
}
