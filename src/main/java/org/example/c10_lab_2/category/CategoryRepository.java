package org.example.c10_lab_2.category;

import org.example.c10_lab_2.category.entity.Category;
import org.springframework.data.repository.ListCrudRepository;

public interface CategoryRepository extends ListCrudRepository<Category, Integer> {

    Category findByName(String name);
    Boolean existsByName(String name);
}
