package com.coordi.service.application.category.usecase;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.coordi.service.application.category.command.CreateCategoryCommand;
import com.coordi.service.application.category.command.UpdateCategoryCommand;
import com.coordi.service.application.category.outport.CategoryRepository;
import com.coordi.service.domain.category.Category;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryInputPort implements CategoryUseCase {

	private final CategoryRepository categoryRepository;

	@Override
	public Category create(CreateCategoryCommand createCommand) {
		return categoryRepository.create(createCommand.toModel());
	}

	@Override
	public Category update(UpdateCategoryCommand updateCommand) {
		return categoryRepository.update(updateCommand.toModel());
	}

	@Override
	public void delete(Long categoryId, String userName) {
		categoryRepository.deleteById(categoryId, userName);
	}

	@Override
	public Optional<Category> findById(Long categoryId) {
		return categoryRepository.findById(categoryId);
	}
}
