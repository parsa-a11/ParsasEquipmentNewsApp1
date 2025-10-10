package com.example.parsasequipmentnewsapp.dto.Post;

import com.example.parsasequipmentnewsapp.modle.Post;
import com.example.parsasequipmentnewsapp.modle.User;
import jakarta.validation.constraints.NotBlank;

public class PostSaveDto {
    private final String image;
    private final String title;
    private final String author;
    private final String slug;
    private final String content;
    private final String excerpt;
    private final String user;

    public PostSaveDto(String image, String title, String author
            , String slug, String content, String excerpt, String user) {
        this.image = image;
        this.title = title;
        this.author = author;
        this.slug = slug;
        this.content = content;
        this.excerpt = excerpt;
        this.user = user;
    }

    @NotBlank(message = "post.save.dto.image.blank")
    public String getImage() {
        return image;
    }

    @NotBlank(message = "post.save.dto.title.blank")
    public String getTitle() {
        return title;
    }

    @NotBlank(message = "post.save.dto.author.blank")
    public String getAuthor() {
        return author;
    }

    @NotBlank(message = "post.save.dto.slug.blank")
    public String getSlug() {
        return slug;
    }

    @NotBlank(message = "post.save.dto.content.blank")
    public String getContent() {
        return content;
    }

    @NotBlank(message = "post.save.dto.excerpt.blank")
    public String getExcerpt() {
        return excerpt;
    }

    @NotBlank(message = "post.save.dto.user.blank")
    public String getUser() {
        return user;
    }

    public Post convertToPost(User user) {
        Post post = new Post();
        post.setImage(image);
        post.setTitle(title);
        post.setAuthor(author);
        post.setSlug(slug);
        post.setContent(content);
        post.setExcerpt(excerpt);
        post.setUser(user);
        return post;
    }
}
