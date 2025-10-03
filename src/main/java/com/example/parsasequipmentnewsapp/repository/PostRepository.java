package com.example.parsasequipmentnewsapp.repository;

import com.example.parsasequipmentnewsapp.modle.Post;
import com.example.parsasequipmentnewsapp.modle.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByDisableDateIsNull();
}
