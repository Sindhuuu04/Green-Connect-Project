
package com.greenconnect.backend.controller;

import com.greenconnect.backend.model.NewsPost;
import com.greenconnect.backend.repository.NewsPostRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/news")
public class NewsController {

    private final NewsPostRepository newsPostRepository;

    public NewsController(NewsPostRepository newsPostRepository) {
        this.newsPostRepository = newsPostRepository;
    }

    @GetMapping
    public List<NewsPost> getAllNews() {
        return newsPostRepository.findAll();
    }

    @GetMapping("/{id}")
    public NewsPost getNewsById(@PathVariable Long id) {
        return newsPostRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "News post not found with id: " + id
                ));
    }

    @PostMapping
    public NewsPost createNews(@Valid @RequestBody NewsPost newsPost) {
        return newsPostRepository.save(newsPost);
    }
}
