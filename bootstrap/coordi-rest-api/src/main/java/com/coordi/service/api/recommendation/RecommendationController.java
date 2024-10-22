package com.coordi.service.api.recommendation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/recommendations")
class RecommendationController {

	/**
	 * 카테고리 별 최저가격 브랜드와 상품 가격, 총액을 조회 API
	 */
	@GetMapping("/min-price-coordination")
	public void retrieveCoordination() {

	}

	/**
	 * 단일 브랜드로 모든 카테고리 상품을 구매할 때
	 * 최저가격에 판매하는 브랜드와 카테고리의 상품가격, 총액을 조회하는 API
	 */
	@GetMapping("/min-price-coordination/single-brand")
	public void retrieveSingleBrandCoordination(@RequestParam String brand) {

	}

	/**
	 * 카테고리 이름으로 최저, 최고 가격 브랜드와 상품 가격을 조회하는 API
	 * @param categoryName
	 */
	@GetMapping("/category-brands")
	public void retrieveCategoryBrands(@RequestParam("categoryName") String categoryName) {

	}
}
