package com.coordi.service.api.adapter.product;

import com.coordi.service.application.product.command.CreateProductCommand;
import com.coordi.service.application.product.command.UpdateProductCommand;

import lombok.experimental.UtilityClass;

@UtilityClass
class ProductCommandConverter {
	public static CreateProductCommand toCreate(ProductRequest request) {
		return CreateProductCommand.builder()
								   .price(request.price())
								   .brandId(request.brandId())
								   .categoryId(request.categoryId())
								   .modifiedBy(request.userName())
								   .build();
	}

	public static UpdateProductCommand toUpdate(ProductRequest request, Long id) {
		return UpdateProductCommand.builder()
								   .id(id)
								   .price(request.price())
								   .brandId(request.brandId())
								   .categoryId(request.categoryId())
								   .modifiedBy(request.userName())
								   .build();
	}
}
