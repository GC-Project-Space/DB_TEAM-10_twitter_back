package com.example.twitterclone.domain.mapping;

import com.example.twitterclone.domain.BaseEntity;
import com.example.twitterclone.domain.Member;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Follow extends BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "follower_id")
    private Member follower; // 팔로우 하는 사람

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "following_id")
    private Member following; // 팔로우 당하는 사람

    //연관 관계 편의 메서드
    public void setFollower(Member member){
        if(this.follower != null)
            member.getFollowerList().remove(this);
        this.follower = member;
        member.getFollowerList().add(this);
    }

    //연관 관계 편의 메서드
    public void setFollowing(Member member){
        if(this.following != null)
            member.getFollowingList().remove(this);
        this.following = member;
        member.getFollowingList().add(this);
    }
}
