package com.example.parsasequipmentnewsapp.service.category;

import com.example.parsasequipmentnewsapp.customeExeption.RuleException;
import com.example.parsasequipmentnewsapp.modle.Category;
import com.example.parsasequipmentnewsapp.repository.CategoryRepository;
import com.example.parsasequipmentnewsapp.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final PostRepository postRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository, PostRepository postRepository) {
        this.categoryRepository = categoryRepository;
        this.postRepository = postRepository;
    }

    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAllByDisableDateIsNull();
    }

    @Override
    public Category findById(long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new RuleException("category.not.found"));
    }

    @Override
    public void delete(long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuleException("category.not.found"));
        category.setDisableDate(LocalDateTime.now());
    }

    @Override
    public void update(long id, Category updateCategory) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuleException("category.not.found"));
        category.setName(updateCategory.getName());
        category.setSlug(updateCategory.getSlug());
        category.setDescription(updateCategory.getDescription());
        category.setPost(updateCategory.getPost());
        categoryRepository.save(category);
    }
}
