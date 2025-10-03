package com.example.parsasequipmentnewsapp.controller;

import com.example.parsasequipmentnewsapp.dto.category.CategoryDto;
import com.example.parsasequipmentnewsapp.dto.category.CategorySaveDto;
import com.example.parsasequipmentnewsapp.dto.SaveDto;
import com.example.parsasequipmentnewsapp.modle.Category;
import com.example.parsasequipmentnewsapp.modle.Post;
import com.example.parsasequipmentnewsapp.service.category.CategoryService;
import com.example.parsasequipmentnewsapp.service.post.PostService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/category")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class CategoryController {

    private final CategoryService categoryService;
    private final PostService postService;

    public CategoryController(CategoryService categoryService, PostService postService) {
        this.categoryService = categoryService;
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<SaveDto> save(@Valid @RequestBody CategorySaveDto categorySaveDto) {
        Post post = postService.findById(categorySaveDto.getPost());
        Category category = categorySaveDto.convertToCategory(post);
        categoryService.save(category);
        return ResponseEntity.ok(new SaveDto(category.getId()));
    }

    @GetMapping
    public ResponseEntity<List<CategoryDto>> findAll() {
        List<Category> categories = categoryService.findAll();
        List<CategoryDto> categoryDtos = categories.stream()
                .map(CategoryDto::convertToDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(categoryDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> findById(@PathVariable Long id) {
        Category category = categoryService.findById(id);
        return ResponseEntity.ok(CategoryDto.convertToDto(category));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SaveDto> delete(@PathVariable Long id) {
        categoryService.delete(id);
        return ResponseEntity.ok(new SaveDto(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SaveDto> update(@PathVariable Long id,
                                          @RequestBody CategorySaveDto categorySaveDto) {
        Post post = postService.findById(categorySaveDto.getPost());
        Category category = categorySaveDto.convertToCategory(post);
        categoryService.update(id, category);
        return ResponseEntity.ok(new SaveDto(id));
    }
}
