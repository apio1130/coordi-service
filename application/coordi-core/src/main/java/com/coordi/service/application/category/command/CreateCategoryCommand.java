package com.coordi.service.application.category.command;

import com.coordi.service.domain.category.Category;

import lombok.Builder;
import lombok.Getter;

@Getter
public class CreateCategoryCommand {

	@Builder
	public CreateCategoryCommand(String name, String modifiedBy) {
		this.name = name;
		this.modifiedBy = modifiedBy;
	}

	private String name;
	private String modifiedBy;

	public Category toModel() {
		return Category.builder()
					   .name(name)
					   .isActive(true)
					   .modifiedBy(modifiedBy)
					   .build();
	}
}
