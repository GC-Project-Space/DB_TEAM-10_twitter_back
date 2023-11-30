package com.example.twitterclone.repository;

import com.example.twitterclone.domain.Member;
import com.example.twitterclone.domain.Post;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByAuthorOrderByCreatedAtDesc(Member author, Pageable pageable);
}

