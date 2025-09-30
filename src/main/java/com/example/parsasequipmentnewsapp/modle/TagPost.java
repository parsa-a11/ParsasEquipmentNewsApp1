package com.example.parsasequipmentnewsapp.modle;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class TagPost extends BaseEntity {
    private Tag tag;
    private Post post;

    @ManyToOne
    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    @ManyToOne
    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
