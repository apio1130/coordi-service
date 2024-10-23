package com.coordi.service.api.adapter.category;

import com.coordi.service.application.category.command.CreateCategoryCommand;
import com.coordi.service.application.category.command.UpdateCategoryCommand;

import lombok.experimental.UtilityClass;

@UtilityClass
class CategoryCommandConverter {
	public static CreateCategoryCommand toCreate(CategoryRequest categoryRequest) {
		return CreateCategoryCommand.builder()
									.name(categoryRequest.name())
									.modifiedBy(categoryRequest.userName())
									.build();
	}
	public static UpdateCategoryCommand toUpdate(CategoryRequest categoryRequest, Long id) {
		return UpdateCategoryCommand.builder()
									.id(id)
									.name(categoryRequest.name())
									.modifiedBy(categoryRequest.userName())
									.build();
	}
}
