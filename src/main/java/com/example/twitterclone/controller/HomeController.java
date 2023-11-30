package com.example.twitterclone.controller;

import com.example.twitterclone.domain.Post;
import com.example.twitterclone.service.HomeService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {
    private final HomeService homeService;

    public HomeController(HomeService postService) {
        this.homeService = postService;
    }

    @GetMapping("")
    public ResponseEntity<Page<Post>> getLatestPosts(@RequestParam(defaultValue = "0") int page) {
        Page<Post> latestPosts = homeService.getLatestPosts(page);
        return ResponseEntity.ok(latestPosts);
    }
}
