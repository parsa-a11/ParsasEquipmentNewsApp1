package com.example.parsasequipmentnewsapp.controller;

import com.example.parsasequipmentnewsapp.dto.SaveDto;
import com.example.parsasequipmentnewsapp.dto.category.CategoryDto;
import com.example.parsasequipmentnewsapp.dto.comment.CommentDto;
import com.example.parsasequipmentnewsapp.dto.comment.CommentSaveDto;
import com.example.parsasequipmentnewsapp.modle.Comment;
import com.example.parsasequipmentnewsapp.modle.Post;
import com.example.parsasequipmentnewsapp.service.comment.CommentService;
import com.example.parsasequipmentnewsapp.service.post.PostService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/comment")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class CommentController {

    private final CommentService commentService;
    private final PostService postService;

    public CommentController(CommentService commentService, PostService postService) {
        this.commentService = commentService;
        this.postService = postService;
    }

    @PostMapping()
    public ResponseEntity<SaveDto> save(@Valid @RequestBody CommentSaveDto commentSaveDto) {
        Post post = postService.findById(commentSaveDto.getPost());
        Comment comment = commentSaveDto.convertToComment(post);
        commentService.save(comment);
        return ResponseEntity.ok(new SaveDto(comment.getId()));
    }

    @GetMapping()
    public ResponseEntity<List<CommentDto>> findAll() {
        List<Comment> comments = commentService.findAll();
        List<CommentDto> commentDtos = comments.stream()
                .map(CommentDto::convertToDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(commentDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommentDto> findById(@PathVariable Long id) {
        Comment comment = commentService.findById(id);
        return ResponseEntity.ok(CommentDto.convertToDto(comment));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<SaveDto> delete(@PathVariable Long id) {
        commentService.delete(id);
        return ResponseEntity.ok(new SaveDto(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SaveDto> update(@PathVariable Long id
            , @RequestBody CommentSaveDto commentSaveDto) {
        Post post = postService.findById(id);
        Comment comment = commentSaveDto.convertToComment(post);
        commentService.update(id, comment);
        return ResponseEntity.ok(new SaveDto(id));
    }
}
