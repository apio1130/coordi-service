package com.coordi.service.storage.adapter.brand;

import com.coordi.service.domain.brand.Brand;

import lombok.experimental.UtilityClass;

@UtilityClass
class BrandDataConverter {

	public static BrandEntity toCreateEntity(Brand brand) {

		return BrandEntity.builder()
							 .name(brand.getName())
							 .createdBy(brand.getModifiedBy())
							 .modifiedBy(brand.getModifiedBy())
							 .build();
	}

	public static BrandEntity toUpdateEntity(BrandEntity beforeEntity, Brand brand) {
		return BrandEntity.builder()
							 .id(brand.getId())
							 .name(brand.getName())
							 .useYn(beforeEntity.getUseYn())
							 .createdBy(beforeEntity.getCreatedBy())
							 .modifiedBy(brand.getModifiedBy())
							 .build();
	}

	public static Brand toModel(BrandEntity entity) {
		return Brand.builder()
					   .id(entity.getId())
					   .name(entity.getName())
					   .isActive("Y".equals(entity.getUseYn()))
					   .modifiedBy(entity.getModifiedBy())
					   .build();
	}
}
