package com.example.twitterclone.service;

import com.example.twitterclone.domain.Member;
import com.example.twitterclone.domain.Post;
import com.example.twitterclone.domain.mapping.PostLike;
import com.example.twitterclone.repository.MemberRepository;
import com.example.twitterclone.repository.PostLikeRepository;
import com.example.twitterclone.repository.PostRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

@Service
public class PostLikeService {
    private final PostLikeRepository postLikeRepository;
    private final PostRepository postRepository;
    private final MemberRepository memberRepository;

    public PostLikeService(PostLikeRepository postLikeRepository, PostRepository postRepository, MemberRepository memberRepository) {
        this.postLikeRepository = postLikeRepository;
        this.postRepository = postRepository;
        this.memberRepository = memberRepository;
    }

    @Transactional
    public void likePost(Long postId, Long memberId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new EntityNotFoundException("Post not found with ID: " + postId));

        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new EntityNotFoundException("Member not found with ID: " + memberId));

        PostLike postLike = PostLike.builder()
                .post(post)
                .member(member)
                .build();

        postLikeRepository.save(postLike);

        // 기타 작업: 좋아요 수 증가 또는 감소 등의 업데이트 작업을 할 수 있습니다.
    }
}
