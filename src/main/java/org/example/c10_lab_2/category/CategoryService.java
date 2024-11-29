package org.example.c10_lab_2.category;

import org.example.c10_lab_2.category.dto.CategoryDto;
import org.example.c10_lab_2.category.entity.Category;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoryService {
    CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryDto> getAllCategories() {
        return categoryRepository.findAll().stream()
                .map(CategoryDto::fromCategory)
                .toList();
    }

    public CategoryDto getCategoryByName(String name) {
        Category category = categoryRepository.findByName(name);
        return CategoryDto.fromCategory(category);
    }

    public int addCategory(CategoryDto categoryDto) {
        if (categoryRepository.existsByName(categoryDto.name())) {
            throw new IllegalArgumentException("Category with name " + categoryDto.name() + " already exists");
        }
        Category category = new Category();
        category.setName(categoryDto.name());
        category.setDescription(categoryDto.description());
        category.setSymbol(categoryDto.symbol());
        categoryRepository.save(category);
        return category.getId();
    }
}
