package com.example.parsasequipmentnewsapp.dto.comment;

import com.example.parsasequipmentnewsapp.modle.Comment;
import com.example.parsasequipmentnewsapp.modle.Post;
import com.example.parsasequipmentnewsapp.modle.Role;

import java.time.LocalDateTime;

public class CommentDto {

    private final long id;
    private final LocalDateTime creationDate;
    private final LocalDateTime updatedAt;
    private final String content;
    private final String authorName;
    private final String authorEmail;
    private final boolean approved;
    private final long postId;
    private final String title;
    private final String author;
    private final String postSlug;
    private final String postContent;
    private final String excerpt;
    private final LocalDateTime publishedDate;
    private final long userId;
    private final String username;
    private final String password;
    private final String email;
    private final String fullName;
    private final Role role;

    public CommentDto(long id, LocalDateTime creationDate, LocalDateTime updatedAt, String content, String authorName, String authorEmail, boolean approved, long postId, String title, String author, String postSlug, String postContent, String excerpt, LocalDateTime publishedDate, long userId, String username, String password, String email, String fullName, Role role) {
        this.id = id;
        this.creationDate = creationDate;
        this.updatedAt = updatedAt;
        this.content = content;
        this.authorName = authorName;
        this.authorEmail = authorEmail;
        this.approved = approved;
        this.postId = postId;
        this.title = title;
        this.author = author;
        this.postSlug = postSlug;
        this.postContent = postContent;
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

    public String getContent() {
        return content;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getAuthorEmail() {
        return authorEmail;
    }

    public boolean isApproved() {
        return approved;
    }

    public long getPostId() {
        return postId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPostSlug() {
        return postSlug;
    }

    public String getPostContent() {
        return postContent;
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

    public static CommentDto convertToDto(Comment comment) {
        return new CommentDto(
                comment.getId(),
                comment.getCreatedAt(),
                comment.getUpdatedAt(),
                comment.getContent(),
                comment.getAuthorName(),
                comment.getAuthorEmail(),
                comment.isApproved(),
                comment.getPost().getId(),
                comment.getPost().getTitle(),
                comment.getPost().getAuthor(),
                comment.getPost().getSlug(),
                comment.getPost().getContent(),
                comment.getPost().getExcerpt(),
                comment.getPost().getPublishedAt(),
                comment.getPost().getUser().getId(),
                comment.getPost().getUser().getUsername(),
                comment.getPost().getUser().getPassword(),
                comment.getPost().getUser().getEmail(),
                comment.getPost().getUser().getFullName(),
                comment.getPost().getUser().getRole()
        );
    }
}
