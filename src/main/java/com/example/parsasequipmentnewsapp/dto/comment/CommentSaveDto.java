package com.example.parsasequipmentnewsapp.dto.comment;

import com.example.parsasequipmentnewsapp.modle.Comment;
import com.example.parsasequipmentnewsapp.modle.Post;
import jakarta.validation.constraints.NotBlank;

public class CommentSaveDto {
    private final String content;
    private final String authorName;
    private final String authorEmail;
    private final boolean approved;
    private final long post;

    public CommentSaveDto(String content, String authorName, String authorEmail, boolean approved, long post) {
        this.content = content;
        this.authorName = authorName;
        this.authorEmail = authorEmail;
        this.approved = approved;
        this.post = post;
    }

    @NotBlank(message = "comment.save.dto.content.blank")
    public String getContent() {
        return content;
    }

    @NotBlank(message = "comment.save.dto.authorName.blank")
    public String getAuthorName() {
        return authorName;
    }

    @NotBlank(message = "comment.save.dto.authorEmail.blank")
    public String getAuthorEmail() {
        return authorEmail;
    }

    @NotBlank(message = "comment.save.dto.approved.blank")
    public boolean isApproved() {
        return approved;
    }

    @NotBlank(message = "comment.save.dto.post.blank")
    public long getPost() {
        return post;
    }

    public Comment convertToComment(Post post) {
        Comment comment = new Comment();
        comment.setContent(content);
        comment.setAuthorName(authorName);
        comment.setAuthorEmail(authorEmail);
        comment.setApproved(approved);
        comment.setPost(post);
        return comment;
    }
}
