package com.example.parsasequipmentnewsapp.modle;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Category extends BaseEntity {
    private String name;
    private String slug;
    private String description;
    private Post post;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @ManyToOne
    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
