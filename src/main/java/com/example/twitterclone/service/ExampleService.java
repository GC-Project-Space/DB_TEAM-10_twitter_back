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
public class ExampleService {
    private final ExampleRepository exampleRepository;

    public Example exampleCreate(ExampleRequest.ExampleCreateDto exampleCreateDto) {
        Example example = ExampleConverter.toExample(exampleCreateDto);
        return exampleRepository.save(example);
    }
}