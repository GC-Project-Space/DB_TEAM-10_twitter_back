package com.example.twitterclone.service;

import com.example.twitterclone.domain.Post;
import com.example.twitterclone.dto.HomeResponse;
import com.example.twitterclone.repository.MemberRepository;
import com.example.twitterclone.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HomeService {

    private final PostRepository postRepository;
    private final MemberRepository memberRepository;

    public List<HomeResponse.homeDto> getLatestPosts() {
        Sort sort = Sort.by(Sort.Direction.ASC, "createdAt");

        // Retrieve the sorted list of posts from the repository
        List<Post> latestPosts = postRepository.findAll(sort);

        // Map Post entities to HomeResponse.homeDto using Java streams
        return latestPosts.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    // Method to convert Post entity to HomeResponse.homeDto
    private HomeResponse.homeDto convertToDto(Post post) {
        return HomeResponse.homeDto.builder()
                .postId(post.getId())
                .content(post.getContent())
                .authorId(post.getAuthor().getId())
                .createdAt(post.getCreatedAt())
                .build();
    }
}
