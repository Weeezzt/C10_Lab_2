package org.example.c10_lab_2.category;

import org.example.c10_lab_2.category.dto.CategoryDto;
import org.example.c10_lab_2.category.exceptionMappers.CategoryNotFoundExceptionMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
public class CategoryController {
    CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public List<CategoryDto> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/categories/{name}")
    public CategoryDto getCategoryByName(@PathVariable String name) {
        try {
            return categoryService.getCategoryByName(name);
        }catch (Exception e){
            throw new CategoryNotFoundExceptionMapper(name);
        }
    }

    @PostMapping("/categories")
    public ResponseEntity<Void> createCategory(@RequestBody CategoryDto categoryDto) {

            int id = categoryService.addCategory(categoryDto);
            return ResponseEntity.created(URI.create("/category/" + id)).build();
    }
}
