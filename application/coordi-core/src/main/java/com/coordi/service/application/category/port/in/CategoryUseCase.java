package com.coordi.service.application.category.port.in;

import java.util.Optional;

import com.coordi.service.application.category.command.CreateCategoryCommand;
import com.coordi.service.application.category.command.UpdateCategoryCommand;
import com.coordi.service.domain.category.Category;

public interface CategoryUseCase {
	Category create(CreateCategoryCommand createCommand);
	Category update(UpdateCategoryCommand updateCommand);
	void delete(Long categoryId, String userName);
	Optional<Category> findById(Long categoryId);
}
