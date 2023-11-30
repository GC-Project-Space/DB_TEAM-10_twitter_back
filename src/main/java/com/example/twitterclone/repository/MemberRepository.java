package com.example.twitterclone.repository;

import com.example.twitterclone.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
