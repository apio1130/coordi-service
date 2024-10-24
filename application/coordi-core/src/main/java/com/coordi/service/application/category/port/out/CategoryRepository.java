package com.coordi.service.application.category.port.out;

import java.util.List;
import java.util.Optional;

import com.coordi.service.domain.category.Category;

public interface CategoryRepository {

	Category create(Category category);

	Category update(Category category);

	Optional<Category> findById(Long id);

	Optional<Category> findByName(String name);

	List<Category> findAll();

	void deleteById(Long id, String userName);
}
