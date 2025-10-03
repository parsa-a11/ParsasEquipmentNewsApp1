package com.example.parsasequipmentnewsapp.service.comment;

import com.example.parsasequipmentnewsapp.modle.Category;
import com.example.parsasequipmentnewsapp.modle.Comment;

import java.util.List;

public interface CommentService {

    void save(Comment comment);

    List<Comment> findAll();

    Comment findById(long id);

    void delete(long id);

    void update(long id, Comment updateComment);

}
