package com.app.FinanceManagement.Impl;

import com.app.FinanceManagement.DTO.CategoryDTO;
import com.app.FinanceManagement.Entity.Category;
import com.app.FinanceManagement.Repository.CategoryRepository;
import com.app.FinanceManagement.Repository.UserRepository;
import com.app.FinanceManagement.Service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CategoryImpl(CategoryRepository categoryRepository, UserRepository userRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        if (categoryDTO.getIdCategory() != null) {
            throw new IllegalArgumentException("El ID no debe proporcionarse al crear una nueva categoría.");
        }
        var category = modelMapper.map(categoryDTO, Category.class);
        category = categoryRepository.save(category);
        return modelMapper.map(category, CategoryDTO.class);
    }

    @Override
    public CategoryDTO getCategoryById(Long id) {
        var category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category with ID " + id + " does not exist."));
        return modelMapper.map(category, CategoryDTO.class);
    }


    public List<CategoryDTO> getAllCategories() {
        var categories = categoryRepository.findAll();
        return categories.stream()
                .map(category -> modelMapper.map(category, CategoryDTO.class))
                .collect(java.util.stream.Collectors.toList());
    }

    @Override
    public CategoryDTO updateCategory(Long id, CategoryDTO categoryDTO) {
        var category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category with ID " + id + " does not exist."));
        category.setName(categoryDTO.getName());
        var updatedCategory = categoryRepository.save(category);
        return modelMapper.map(updatedCategory, CategoryDTO.class);
    }

    @Override
    public void deleteCategory(Long id) {
        if (!categoryRepository.existsById(id)) {
            throw new RuntimeException("Category with ID " + id + " does not exist.");
        }
        categoryRepository.deleteById(id);
    }
}