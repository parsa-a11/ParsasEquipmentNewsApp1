package com.example.parsasequipmentnewsapp.repository;

import com.example.parsasequipmentnewsapp.modle.Comment;
import com.example.parsasequipmentnewsapp.modle.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPostAndApproved(Post post, boolean approved);
}
