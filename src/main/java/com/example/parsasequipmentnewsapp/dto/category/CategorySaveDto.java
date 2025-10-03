package com.example.parsasequipmentnewsapp.dto.category;

import com.example.parsasequipmentnewsapp.modle.Category;
import com.example.parsasequipmentnewsapp.modle.Post;
import jakarta.validation.constraints.NotBlank;

public class CategorySaveDto {

    private final String name;
    private final String slug;
    private final String description;
    private final long post;

    public CategorySaveDto(String name, String slug, String description, long post) {
        this.name = name;
        this.slug = slug;
        this.description = description;
        this.post = post;
    }

    @NotBlank(message = "category.save.dto.name.blank")
    public String getName() {
        return name;
    }

    @NotBlank(message = "category.save.dto.slug.blank")
    public String getSlug() {
        return slug;
    }

    @NotBlank(message = "category.save.dto.description.blank")
    public String getDescription() {
        return description;
    }

    @NotBlank(message = "category.save.dto.post.blank")
    public long getPost() {
        return post;
    }

    public Category convertToCategory(Post post) {
        Category category = new Category();
        category.setName(name);
        category.setSlug(slug);
        category.setDescription(description);
        category.setPost(post);
        return category;
    }
}
