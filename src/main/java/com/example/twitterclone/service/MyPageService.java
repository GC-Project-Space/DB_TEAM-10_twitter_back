package com.example.twitterclone.service;

import com.example.twitterclone.domain.Member;
import com.example.twitterclone.domain.Post;
import com.example.twitterclone.domain.mapping.Follow;
import com.example.twitterclone.dto.MyPageResponse;
import com.example.twitterclone.repository.FollowRepository;
import com.example.twitterclone.repository.MemberRepository;
import com.example.twitterclone.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class MyPageService {
    private final MemberRepository memberRepository;
    private final PostRepository postRepository;
    private final FollowRepository followRepository;

    public MyPageResponse.mypageDto getMyPageInfo(Long memberId, int page, int size) {

        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new EntityNotFoundException("Member not found"));

        Pageable pageable = PageRequest.of(page, size, Sort.by("createdAt").descending());

        List<Post> posts = postRepository.findByAuthorOrderByCreatedAtDesc( member, pageable);
        List<Follow> followerList = followRepository.findByFollowing(member);
        List<Follow> followingList = followRepository.findByFollower(member);

        return mapToMyPageDTO(member, posts, followerList, followingList);
    }

    private MyPageResponse.mypageDto mapToMyPageDTO(Member member, List<Post> posts, List<Follow> followerList, List<Follow> followingList) {
        // Convert entities to DTOs
        List<MyPageResponse.PostDTO> postDTOs = posts.stream()
                .map(this::mapToPostDTO)
                .collect(Collectors.toList());

        int followerCount = followerList.size();
        int followingCount = followingList.size();

        return MyPageResponse.mypageDto.builder()
                .followCount(followingCount)
                .followerCount(followerCount)
                .posts(postDTOs)
                .build();
    }

    private MyPageResponse.PostDTO mapToPostDTO(Post post) {
        return MyPageResponse.PostDTO.builder()
                .id(post.getId())
                .content(post.getContent())
                .authorId(post.getAuthor().getId())
                .createdAt(post.getCreatedAt())
                .build();

    }
}
