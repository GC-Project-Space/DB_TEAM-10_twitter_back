package com.example.twitterclone.domain;

import com.example.twitterclone.domain.mapping.PostTag;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class HashTag extends BaseEntity{

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String name;

    @OneToMany(mappedBy = "hashTag", cascade = CascadeType.ALL)
    private List<PostTag> postTagList=new ArrayList<>();
}
