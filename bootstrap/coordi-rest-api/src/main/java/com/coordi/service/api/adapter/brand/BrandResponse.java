package com.coordi.service.api.adapter.brand;

import com.coordi.service.domain.brand.Brand;

record BrandResponse(String brandName) {

	public static BrandResponse from(Brand brand) {
		return new BrandResponse(brand.getName());
	}
}
