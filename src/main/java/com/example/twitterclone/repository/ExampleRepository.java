package com.example.twitterclone.repository;


import com.example.twitterclone.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

//ExampleRepository의 역할 : Example 객체를 DB에 저장하고, 조회하는 역할을 한다.
public interface ExampleRepository extends JpaRepository<Example, Long> {

}
