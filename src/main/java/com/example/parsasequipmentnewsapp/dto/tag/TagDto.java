package com.example.parsasequipmentnewsapp.dto.tag;

import com.example.parsasequipmentnewsapp.modle.Tag;

import java.time.LocalDateTime;

public class TagDto {
    private final long id;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;
    private final String name;
    private final String slug;

    public TagDto(long id, LocalDateTime createdAt, LocalDateTime updatedAt, String name, String slug) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.name = name;
        this.slug = slug;
    }

    public long getId() {
        return id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
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

    public static TagDto convertToDto(Tag tag) {
        return new TagDto(
                tag.getId(),
                tag.getCreatedAt(),
                tag.getUpdatedAt(),
                tag.getName(),
                tag.getSlug()
        );
    }
}
