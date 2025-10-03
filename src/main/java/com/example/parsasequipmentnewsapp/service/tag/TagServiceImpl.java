package com.example.parsasequipmentnewsapp.service.tag;

import com.example.parsasequipmentnewsapp.customeExeption.RuleException;
import com.example.parsasequipmentnewsapp.modle.Post;
import com.example.parsasequipmentnewsapp.modle.Tag;
import com.example.parsasequipmentnewsapp.repository.PostRepository;
import com.example.parsasequipmentnewsapp.repository.TagRepository;
import com.example.parsasequipmentnewsapp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;

    public TagServiceImpl(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Override
    public void save(Tag tag) {
        tagRepository.save(tag);
    }

    @Override
    public List<Tag> findAll() {
        return tagRepository.findAllByDisableDateIsNull();
    }

    @Override
    public Tag findById(long id) {
        return tagRepository.findById(id)
                .orElseThrow(() -> new RuleException("tag.not.found"));
    }

    @Override
    public void delete(long id) {
        Tag tag = tagRepository.findById(id)
                .orElseThrow(() -> new RuleException("tag.not.found"));
        tag.setDisableDate(LocalDateTime.now());
    }

    @Override
    public void update(long id, Tag updatedTag) {
        Tag tag = tagRepository.findById(id)
                .orElseThrow(() -> new RuleException("tag.not.found"));
        tag.setName(updatedTag.getName());
        tag.setSlug(updatedTag.getSlug());
        tagRepository.save(tag);
    }
}
