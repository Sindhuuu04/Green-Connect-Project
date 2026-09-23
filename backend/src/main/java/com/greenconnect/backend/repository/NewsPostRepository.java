package com.greenconnect.backend.repository;

import com.greenconnect.backend.model.NewsPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsPostRepository extends JpaRepository<NewsPost, Long> {
}
