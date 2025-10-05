package com.example.parsasequipmentnewsapp.dto.tag;

import com.example.parsasequipmentnewsapp.modle.Tag;
import jakarta.validation.constraints.NotBlank;

public class TagSaveDto {
    private final String name;
    private final String slug;

    public TagSaveDto(String name, String slug) {
        this.name = name;
        this.slug = slug;
    }

    @NotBlank(message = "tag.save.dto.name.blank")
    public String getName() {
        return name;
    }

    @NotBlank(message = "tag.save.dto.slug.blank")
    public String getSlug() {
        return slug;
    }

    public Tag convertToTag() {
        Tag tag = new Tag();
        tag.setName(name);
        tag.setSlug(slug);
        return tag;
    }
}
