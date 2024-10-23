package com.coordi.service.storage.adapter.product;


import com.coordi.service.domain.product.Product;

import lombok.experimental.UtilityClass;

@UtilityClass
class ProductDataConverter {

	public static ProductEntity toCreateEntity(Product product) {

		return ProductEntity.builder()
							.price(product.getPrice())
							.brandId(product.getBrandId())
							.categoryId(product.getCategoryId())
							.createdBy(product.getModifiedBy())
							.modifiedBy(product.getModifiedBy())
							.build();
	}

	public static ProductEntity toUpdateEntity(ProductEntity beforeEntity, Product product) {
		return ProductEntity.builder()
							.id(product.getId())
							.price(product.getPrice())
							.brandId(product.getBrandId())
							.categoryId(product.getCategoryId())
							.useYn(beforeEntity.getUseYn())
							.createdBy(beforeEntity.getCreatedBy())
							.modifiedBy(product.getModifiedBy())
							.build();
	}

	public static Product toModel(ProductEntity entity) {
		return Product.builder()
					  .id(entity.getId())
					  .price(entity.getPrice())
					  .brandId(entity.getBrandId())
					  .categoryId(entity.getCategoryId())
					  .isActive("Y".equals(entity.getUseYn()))
					  .modifiedBy(entity.getModifiedBy())
					  .build();
	}
}
