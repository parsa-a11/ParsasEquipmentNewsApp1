package com.example.parsasequipmentnewsapp.controller;

import com.example.parsasequipmentnewsapp.dto.SaveDto;
import com.example.parsasequipmentnewsapp.dto.tag.TagDto;
import com.example.parsasequipmentnewsapp.dto.tag.TagSaveDto;
import com.example.parsasequipmentnewsapp.modle.Tag;
import com.example.parsasequipmentnewsapp.service.tag.TagService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tag")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class TagController {
    private final TagService tagService;

    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @PostMapping()
    public ResponseEntity<SaveDto> save(@RequestBody TagSaveDto tagSaveDto) {
        Tag tag = tagSaveDto.convertToTag();
        tagService.save(tag);
        return ResponseEntity.ok(new SaveDto(tag.getId()));
    }

    @GetMapping()
    public ResponseEntity<List<TagDto>> findAll() {
        List<Tag> tags = tagService.findAll();
        List<TagDto> tagDtos = tags.stream()
                .map(TagDto::convertToDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(tagDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TagDto> findById(@PathVariable long id) {
        Tag tag = tagService.findById(id);
        return ResponseEntity.ok(TagDto.convertToDto(tag));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SaveDto> delete(@PathVariable long id) {
        tagService.delete(id);
        return ResponseEntity.ok(new SaveDto(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SaveDto> update(@PathVariable long id
            , @RequestBody TagSaveDto tagSaveDto) {
        Tag tag = tagSaveDto.convertToTag();
        tagService.update(id, tag);
        return ResponseEntity.ok(new SaveDto(id));
    }
}
