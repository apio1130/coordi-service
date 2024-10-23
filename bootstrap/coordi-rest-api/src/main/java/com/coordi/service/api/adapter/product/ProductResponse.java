package com.coordi.service.api.adapter.product;

import java.math.BigInteger;

import com.coordi.service.domain.product.Product;

record ProductResponse(BigInteger price, Long brandId, Long categoryId) {
	public static ProductResponse from(Product product) {
		return new ProductResponse(product.getPrice(), product.getBrandId(), product.getCategoryId());
	}
}
