package com.example.twitterclone.repository;

import com.example.twitterclone.domain.Member;
import com.example.twitterclone.domain.mapping.Follow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FollowRepository extends JpaRepository<Follow, Long> {

    List<Follow> findByFollowing(Member following);
    List<Follow> findByFollower(Member follower);
}
