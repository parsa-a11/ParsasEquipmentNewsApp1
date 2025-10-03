package com.example.parsasequipmentnewsapp.service.comment;

import com.example.parsasequipmentnewsapp.customeExeption.RuleException;
import com.example.parsasequipmentnewsapp.modle.Category;
import com.example.parsasequipmentnewsapp.modle.Comment;
import com.example.parsasequipmentnewsapp.repository.CommentRepository;
import com.example.parsasequipmentnewsapp.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    public CommentServiceImpl(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    @Override
    public void save(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public List<Comment> findAll() {
        return commentRepository.findAllByDisableDateIsNull();
    }

    @Override
    public Comment findById(long id) {
        return commentRepository.findById(id)
                .orElseThrow(() -> new RuleException("comment.not.found"));
    }

    @Override
    public void delete(long id) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new RuleException("comment.not.found"));
        comment.setDisableDate(LocalDateTime.now());
    }

    @Override
    public void update(long id, Comment updateComment) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new RuleException("comment.not.found"));
        comment.setContent(updateComment.getContent());
        comment.setAuthorName(updateComment.getAuthorName());
        comment.setAuthorEmail(updateComment.getAuthorEmail());
        comment.setApproved(updateComment.isApproved());
        comment.setPost(updateComment.getPost());
        commentRepository.save(comment);
    }
}
