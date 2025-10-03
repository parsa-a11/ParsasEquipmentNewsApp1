package com.example.parsasequipmentnewsapp.dto.category;

import com.example.parsasequipmentnewsapp.modle.Category;
import com.example.parsasequipmentnewsapp.modle.Role;
import org.apache.tomcat.util.digester.Rule;

import java.time.LocalDateTime;

public class CategoryDto {

    private final long id;
    private final LocalDateTime creationDate;
    private final LocalDateTime updatedAt;
    private final String name;
    private final String slug;
    private final String description;
    private final long postId;
    private final String title;
    private final String author;
    private final String postSlug;
    private final String content;
    private final String excerpt;
    private final LocalDateTime publishedDate;
    private final long userId;
    private final String username;
    private final String password;
    private final String email;
    private final String fullName;
    private final Role role;

    public CategoryDto(long id, LocalDateTime creationDate, LocalDateTime updatedAt, String name, String slug, String description, long postId, String title, String author, String postSlug, String content, String excerpt, LocalDateTime publishedDate, long userId, String username, String password, String email, String fullName, Role role) {
        this.id = id;
        this.creationDate = creationDate;
        this.updatedAt = updatedAt;
        this.name = name;
        this.slug = slug;
        this.description = description;
        this.postId = postId;
        this.title = title;
        this.author = author;
        this.postSlug = postSlug;
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

    public String getName() {
        return name;
    }

    public String getSlug() {
        return slug;
    }

    public String getDescription() {
        return description;
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

    public static CategoryDto convertToDto(Category category) {
        return new CategoryDto(
                category.getId(),
                category.getCreatedAt(),
                category.getUpdatedAt(),
                category.getName(),
                category.getSlug(),
                category.getDescription(),
                category.getPost().getId(),
                category.getPost().getTitle(),
                category.getPost().getAuthor(),
                category.getPost().getSlug(),
                category.getPost().getContent(),
                category.getPost().getExcerpt(),
                category.getPost().getPublishedAt(),
                category.getPost().getUser().getId(),
                category.getPost().getUser().getUsername(),
                category.getPost().getUser().getPassword(),
                category.getPost().getUser().getEmail(),
                category.getPost().getUser().getFullName(),
                category.getPost().getUser().getRole()
        );
    }
}
