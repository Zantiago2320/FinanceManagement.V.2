package com.app.FinanceManagement.Service;

import com.app.FinanceManagement.DTO.CategoryDTO;
import com.app.FinanceManagement.Entity.Category;

import java.util.List;

public interface CategoryService {
    CategoryDTO createCategory(CategoryDTO categoryDTO);
    CategoryDTO getCategoryById(Long id);
    List<CategoryDTO> getAllCategories();
    CategoryDTO updateCategory(Long id, CategoryDTO categoryDTO);
    void deleteCategory(Long id);
}
