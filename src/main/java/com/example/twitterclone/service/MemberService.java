package com.example.twitterclone.service;

import com.example.twitterclone.domain.Member;
import com.example.twitterclone.domain.Post;
import com.example.twitterclone.domain.mapping.Follow;
import com.example.twitterclone.dto.MyPageResponse;
import com.example.twitterclone.dto.UserRequest;
import com.example.twitterclone.repository.MemberRepository;
import com.example.twitterclone.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final PostRepository postRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository, PostRepository postRepository) {

        this.memberRepository = memberRepository;
        this.postRepository = postRepository;
    }

    public Member signUp(UserRequest.SignUpDto request) {
        // 추가적인 로직이 있을 수 있으나 간단하게 저장만 수행
        Member newMember = Member.builder()
                .loginId(request.getLoginId())
                .password(request.getPassword())
                .name(request.getName())
                .build();

        return memberRepository.save(newMember);
    }

    public void changePassword(Long userId, String newPassword) {
        Member user = memberRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + userId.toString()));

        //비밀번호 변경 로직
        user.changePassword(newPassword);
        //변경 정보 저장
        memberRepository.save(user);
    }

    public void followMember(Long followerId, Long followingId) {
        Member follower = memberRepository.findById(followerId)
                .orElseThrow(() -> new EntityNotFoundException("Follower not found with id: " + followerId));

        Member following = memberRepository.findById(followingId)
                .orElseThrow(() -> new EntityNotFoundException("Following member not found with id: " + followingId));

        Follow follow = Follow.builder()
                .follower(follower)
                .following(following)
                .build();

        follower.getFollowerList().add(follow);
        following.getFollowingList().add(follow);

        memberRepository.save(follower);
        memberRepository.save(following);
    }

}
