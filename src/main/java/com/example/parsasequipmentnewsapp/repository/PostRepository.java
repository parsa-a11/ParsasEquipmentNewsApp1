package com.example.parsasequipmentnewsapp.repository;

import com.example.parsasequipmentnewsapp.modle.Post;
import com.example.parsasequipmentnewsapp.modle.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
    Optional<Post> findBySlug(String slug);
    Page<Post> findByStatus(Status status, Pageable pageable);
    Page<Post> findByTitleContainingIgnoreCaseOrContentContainingIgnoreCaseAndStatus(String t, String c, Status status, Pageable pageable);
}
