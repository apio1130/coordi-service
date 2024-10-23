package com.coordi.service.storage.adapter.category;

import com.coordi.service.domain.category.Category;

import lombok.experimental.UtilityClass;

@UtilityClass
class CategoryDataConverter {

	public static CategoryEntity toCreateEntity(Category category) {

		return CategoryEntity.builder()
							 .name(category.getName())
							 .createdBy(category.getModifiedBy())
							 .modifiedBy(category.getModifiedBy())
							 .build();
	}

	public static CategoryEntity toUpdateEntity(CategoryEntity beforeEntity, Category category) {
		return CategoryEntity.builder()
							 .id(category.getId())
							 .name(category.getName())
							 .useYn(beforeEntity.getUseYn())
							 .createdBy(beforeEntity.getCreatedBy())
							 .modifiedBy(category.getModifiedBy())
							 .build();
	}

	public static Category toModel(CategoryEntity entity) {
		return Category.builder()
					   .id(entity.getId())
					   .name(entity.getName())
					   .isActive("Y".equals(entity.getUseYn()))
					   .modifiedBy(entity.getModifiedBy())
					   .build();
	}
}
