package com.coordi.service.application.product.command;

import java.math.BigInteger;

import com.coordi.service.domain.product.Product;

import lombok.Builder;
import lombok.Getter;

@Getter
public class UpdateProductCommand {

	@Builder
	public UpdateProductCommand(Long id, BigInteger price, Long brandId, Long categoryId, String modifiedBy) {
		this.id = id;
		this.price = price;
		this.brandId = brandId;
		this.categoryId = categoryId;
		this.modifiedBy = modifiedBy;
	}

	private Long id;
	private BigInteger price;
	private Long brandId;
	private Long categoryId;
	private String modifiedBy;

	public Product toModel() {
		return Product.builder()
					  .id(id)
					  .price(price)
					  .brandId(brandId)
					  .categoryId(categoryId)
					  .isActive(true)
					  .modifiedBy(modifiedBy)
					  .build();
	}
}
