package com.example.parsasequipmentnewsapp.service.tag;

import com.example.parsasequipmentnewsapp.modle.Post;
import com.example.parsasequipmentnewsapp.modle.Tag;

import java.util.List;

public interface TagService {

    void save(Tag tag);

    List<Tag> findAll();

    Tag findById(long id);

    void delete(long id);

    void update(long id, Tag updateTag);

}
