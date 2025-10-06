package com.example.parsasequipmentnewsapp.service.post;

import com.example.parsasequipmentnewsapp.customeExeption.RuleException;
import com.example.parsasequipmentnewsapp.modle.Comment;
import com.example.parsasequipmentnewsapp.modle.Post;
import com.example.parsasequipmentnewsapp.repository.CommentRepository;
import com.example.parsasequipmentnewsapp.repository.PostRepository;
import com.example.parsasequipmentnewsapp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public PostServiceImpl(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void save(Post post) {
        postRepository.save(post);
    }

    @Override
    public List<Post> findAll() {
        return postRepository.findAllByDisableDateIsNull();
    }

    @Override
    public Post findById(long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new RuleException("post.not.found"));
    }

    @Override
    public void delete(long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuleException("post.not.found"));
        post.setDisableDate(LocalDateTime.now());
    }

    @Override
    public void update(long id, Post updatePost) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuleException("post.not.found"));
        post.setTitle(updatePost.getTitle());
        post.setAuthor(updatePost.getAuthor());
        post.setSlug(updatePost.getSlug());
        post.setContent(updatePost.getContent());
        post.setExcerpt(updatePost.getExcerpt());
        post.setUser(updatePost.getUser());
        postRepository.save(post);
    }

    @Override
    public List<Post> top4Posts() {
        return postRepository.findTop4ByDisableDateIsNull();
    }
}
