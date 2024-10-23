package com.coordi.service.application.product.command;

import java.math.BigInteger;

import com.coordi.service.domain.category.Category;
import com.coordi.service.domain.product.Product;

import lombok.Builder;
import lombok.Getter;

@Getter
public class CreateProductCommand {

	@Builder
	public CreateProductCommand(BigInteger price, Long brandId, Long categoryId, String modifiedBy) {
		this.price = price;
		this.brandId = brandId;
		this.categoryId = categoryId;
		this.modifiedBy = modifiedBy;
	}

	private BigInteger price;
	private Long brandId;
	private Long categoryId;
	private String modifiedBy;

	public Product toModel() {
		return Product.builder()
					  .price(price)
					  .brandId(brandId)
					  .categoryId(categoryId)
					  .isActive(true)
					  .modifiedBy(modifiedBy)
					  .build();
	}
}
