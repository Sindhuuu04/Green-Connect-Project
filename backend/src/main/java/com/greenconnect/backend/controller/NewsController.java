package com.greenconnect.backend.controller;

import com.greenconnect.backend.model.NewsPost;
import com.greenconnect.backend.repository.NewsPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Backs the "Environmental News & Stories" page
@RestController
@RequestMapping("/api/news")
public class NewsController {

    @Autowired
    private NewsPostRepository newsPostRepository;

    @GetMapping
    public List<NewsPost> getAllNews() {
        return newsPostRepository.findAll();
    }

    @GetMapping("/{id}")
    public NewsPost getNewsById(@PathVariable Long id) {
        return newsPostRepository.findById(id).orElse(null);
    }

    @PostMapping
    public NewsPost createNews(@RequestBody NewsPost newsPost) {
        return newsPostRepository.save(newsPost);
    }
}
