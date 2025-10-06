package com.example.parsasequipmentnewsapp.controller;

import com.example.parsasequipmentnewsapp.dto.Post.PostDto;
import com.example.parsasequipmentnewsapp.dto.Post.PostSaveDto;
import com.example.parsasequipmentnewsapp.dto.SaveDto;
import com.example.parsasequipmentnewsapp.modle.Post;
import com.example.parsasequipmentnewsapp.modle.User;
import com.example.parsasequipmentnewsapp.service.post.PostService;
import com.example.parsasequipmentnewsapp.service.user.CustomUserDetailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/post")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class PostController {
    private final PostService postService;
    private final CustomUserDetailService customUserDetailService;

    public PostController(PostService postService, CustomUserDetailService customUserDetailService) {
        this.postService = postService;
        this.customUserDetailService = customUserDetailService;
    }

    @PostMapping()
    public ResponseEntity<SaveDto> save (@RequestBody PostSaveDto postSaveDto) {
        User user = customUserDetailService.findByUsername(postSaveDto.getUser());
        Post post = postSaveDto.convertToPost(user);
        postService.save(post);
        return ResponseEntity.ok(new SaveDto(post.getId()));
    }

    @GetMapping()
    public ResponseEntity<List<PostDto>> findAll() {
        List<Post> posts = postService.findAll();
        List<PostDto> postDtos = posts.stream()
                .map(PostDto::convertToDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(postDtos);
    }

    @GetMapping("/top4posts")
    public ResponseEntity<?> findTop4Posts() {
        postService.top4Posts();
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDto> findById(@PathVariable long id) {
        Post post = postService.findById(id);
        return ResponseEntity.ok(PostDto.convertToDto(post));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SaveDto> delete(@PathVariable long id) {
        postService.delete(id);
        return ResponseEntity.ok(new SaveDto(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SaveDto> update(@PathVariable long id
            , @RequestBody PostSaveDto postSaveDto) {
        User user = customUserDetailService.findByUsername(postSaveDto.getUser());
        Post post = postSaveDto.convertToPost(user);
        postService.update(id, post);
        return ResponseEntity.ok(new SaveDto(id));
    }
}
