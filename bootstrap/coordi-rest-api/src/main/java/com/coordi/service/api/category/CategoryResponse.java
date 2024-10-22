package com.coordi.service.api.category;

import com.coordi.service.domain.category.Category;

public record CategoryResponse(String categoryName) {

	public static CategoryResponse from(Category category) {
		return new CategoryResponse(category.getName());
	}
}
