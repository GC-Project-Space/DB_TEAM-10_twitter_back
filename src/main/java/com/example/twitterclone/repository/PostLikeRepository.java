package com.example.twitterclone.repository;

import com.example.twitterclone.domain.mapping.PostLike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostLikeRepository extends JpaRepository<PostLike, Long> {
}
