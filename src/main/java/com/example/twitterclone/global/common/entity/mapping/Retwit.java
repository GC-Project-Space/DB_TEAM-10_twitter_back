package com.example.twitterclone.global.common.entity.mapping;

import com.example.twitterclone.global.common.entity.BaseEntity;
import com.example.twitterclone.global.common.entity.Member;
import com.example.twitterclone.global.common.entity.Post;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Retwit extends BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;
}
