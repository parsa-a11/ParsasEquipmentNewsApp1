package com.example.parsasequipmentnewsapp.service.post;

import com.example.parsasequipmentnewsapp.modle.Comment;
import com.example.parsasequipmentnewsapp.modle.Post;

import java.util.List;

public interface PostService {

    void save(Post post);

    List<Post> findAll();

    Post findById(long id);

    void delete(long id);

    void update(long id, Post updatePost);

}
