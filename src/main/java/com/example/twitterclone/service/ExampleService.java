package com.example.twitterclone.service;

import com.example.twitterclone.converter.ExampleConverter;
import com.example.twitterclone.domain.Example;
import com.example.twitterclone.dto.ExampleRequest;
import com.example.twitterclone.repository.ExampleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Service class for Example
 */
@Slf4j
@RequiredArgsConstructor
@Service
// Example 관련 비즈니스 로직을 처리하는 클래스
//비즈니스 로직 : 사용자가 원하는 기능을 수행하기 위해 작성하는 프로그램 코드
public class ExampleService {
    private final ExampleRepository exampleRepository; // ExampleRepository 객체를 생성
    // ExampleRepository 객체를 생성하는 이유 : Example 객체를 DB에 저장하고, 조회하는 역할을 하기 위해서

    // Example 객체를 생성하는 메소드
    public Example exampleCreate(ExampleRequest.ExampleCreateDto exampleCreateDto) {
        Example example = ExampleConverter.toExample(exampleCreateDto); // Example 객체를 생성
        return exampleRepository.save(example); // Example 객체를 DB에 저장
    }
}