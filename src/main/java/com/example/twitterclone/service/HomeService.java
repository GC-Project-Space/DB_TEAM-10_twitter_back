package com.example.twitterclone.service;

import com.example.twitterclone.domain.Post;
import com.example.twitterclone.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class HomeService {

    private final PostRepository postRepository;

    @Autowired
    public HomeService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Page<Post> getLatestPosts(int page) {
        int pageSize = 20;
        Pageable pageable = PageRequest.of(page, pageSize, Sort.by("createdAt").descending());
        return postRepository.findAll(pageable);
    }
}
