
package com.greenconnect.backend.controller;

import com.greenconnect.backend.model.NewsPost;
import com.greenconnect.backend.repository.NewsPostRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;

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
    @PreAuthorize("hasRole('SUPER_ADMIN')")
    public NewsPost createNews(@Valid @RequestBody NewsPost newsPost) {
        return newsPostRepository.save(newsPost);
    }


    @PutMapping("/{id}")
    @PreAuthorize("hasRole('SUPER_ADMIN')")
    public NewsPost updateNews(
            @PathVariable Long id,
            @Valid @RequestBody NewsPost updatedNews
    ) {
        NewsPost existingNews = newsPostRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "News post not found with id: " + id
                ));

        existingNews.setTitle(updatedNews.getTitle());
        existingNews.setSummary(updatedNews.getSummary());
        existingNews.setContent(updatedNews.getContent());
        existingNews.setAuthor(updatedNews.getAuthor());
        existingNews.setPublishedOn(updatedNews.getPublishedOn());

        return newsPostRepository.save(existingNews);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('SUPER_ADMIN')")
    public ResponseEntity<Void> deleteNews(@PathVariable Long id) {
        NewsPost existingNews = newsPostRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "News post not found with id: " + id
                ));

        newsPostRepository.delete(existingNews);
        return ResponseEntity.noContent().build();
    }
}
