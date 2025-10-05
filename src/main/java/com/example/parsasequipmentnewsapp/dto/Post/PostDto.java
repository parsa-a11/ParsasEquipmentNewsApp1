package com.example.parsasequipmentnewsapp.dto.Post;

import com.example.parsasequipmentnewsapp.modle.Post;
import com.example.parsasequipmentnewsapp.modle.Role;

import java.time.LocalDateTime;

public class PostDto {
    private final long id;
    private final LocalDateTime creationDate;
    private final LocalDateTime updatedAt;
    private final String title;
    private final String author;
    private final String slug;
    private final String content;
    private final String excerpt;
    private final LocalDateTime publishedDate;
    private final long userId;
    private final String username;
    private final String password;
    private final String email;
    private final String fullName;
    private final Role role;

    public PostDto(long id, LocalDateTime creationDate, LocalDateTime updatedAt, String title, String author, String slug, String content, String excerpt, LocalDateTime publishedDate, long userId, String username, String password, String email, String fullName, Role role) {
        this.id = id;
        this.creationDate = creationDate;
        this.updatedAt = updatedAt;
        this.title = title;
        this.author = author;
        this.slug = slug;
        this.content = content;
        this.excerpt = excerpt;
        this.publishedDate = publishedDate;
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.fullName = fullName;
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getSlug() {
        return slug;
    }

    public String getContent() {
        return content;
    }

    public String getExcerpt() {
        return excerpt;
    }

    public LocalDateTime getPublishedDate() {
        return publishedDate;
    }

    public long getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getFullName() {
        return fullName;
    }

    public Role getRole() {
        return role;
    }

    public static PostDto convertToDto(Post post) {
        return new PostDto(
                post.getId(),
                post.getCreatedAt(),
                post.getUpdatedAt(),
                post.getTitle(),
                post.getAuthor(),
                post.getSlug(),
                post.getContent(),
                post.getExcerpt(),
                post.getPublishedAt(),
                post.getUser().getId(),
                post.getUser().getUsername(),
                post.getUser().getPassword(),
                post.getUser().getEmail(),
                post.getUser().getFullName(),
                post.getUser().getRole()
        );
    }
}
