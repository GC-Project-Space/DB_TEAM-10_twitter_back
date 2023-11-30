package com.example.twitterclone.service;

import com.example.twitterclone.domain.Member;
import com.example.twitterclone.dto.UserRequest;
import com.example.twitterclone.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
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
}
