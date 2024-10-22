package com.coordi.service.application.category.command;

import com.coordi.service.domain.category.Category;

import lombok.Builder;
import lombok.Getter;

@Getter
public class UpdateCategoryCommand {

	@Builder
	public UpdateCategoryCommand(Long id, String name, String modifiedBy) {
		this.id = id;
		this.name = name;
		this.modifiedBy = modifiedBy;
	}

	private Long id;
	private String name;
	private String modifiedBy;

	public Category toModel() {
		return Category.builder()
			.id(id)
			.name(name)
			.modifiedBy(modifiedBy)
			.build();
	}
}
