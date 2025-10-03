package com.example.parsasequipmentnewsapp.service.category;

import com.example.parsasequipmentnewsapp.modle.Category;

import java.util.List;

public interface CategoryService {

    void save(Category category);

    List<Category> findAll();

    Category findById(long id);

    void delete(long id);

    void update(long id, Category updateCategory);

}
