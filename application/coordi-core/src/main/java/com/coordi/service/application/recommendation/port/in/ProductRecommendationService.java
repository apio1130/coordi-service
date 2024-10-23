package com.coordi.service.application.recommendation.port.in;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.coordi.service.application.brand.port.out.BrandRepository;
import com.coordi.service.application.category.port.out.CategoryRepository;
import com.coordi.service.application.common.exception.ErrorCode;
import com.coordi.service.application.product.port.out.ProductRepository;
import com.coordi.service.application.recommendation.port.out.ProductRecommendationRepository;
import com.coordi.service.domain.brand.Brand;
import com.coordi.service.domain.category.Category;
import com.coordi.service.domain.product.Product;
import com.coordi.service.domain.recommendation.MinMaxPriceProducts;
import com.coordi.service.domain.recommendation.RecommendationProduct;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
class ProductRecommendationService implements ProductRecommendationUseCase {

	private final ProductRecommendationRepository productRecommendationRepository;
	private final CategoryRepository categoryRepository;
	private final ProductRepository productRepository;
	private final BrandRepository brandRepository;

	@Override
	public List<RecommendationProduct> findMinPriceProductsByCategory() {
		List<RecommendationProduct> result = new ArrayList<>();
		List<Category> categories = categoryRepository.findAll();
		for (Category category : categories) {
			RecommendationProduct minPriceByCategory = productRecommendationRepository.findMinPriceByCategory(category.getId());
			minPriceByCategory.changeCategoryName(category.getName());
			bindingBrandName(minPriceByCategory);
			result.add(minPriceByCategory);
		}
		return result;
	}

	@Override
	public List<RecommendationProduct> findMaxPriceProductsByCategory() {
		return List.of();
	}

	@Override
	public RecommendationProduct findMinPriceProductByCategory(String categoryName) {
		return null;
	}

	@Override
	public RecommendationProduct findMaxPriceProductByCategory(String categoryName) {
		return null;
	}

	@Override
	public List<RecommendationProduct> findMinPriceProductsBySingleBrand() {
		Long brandId = productRecommendationRepository.findTopByMinTotalPriceBrand();
		Brand brand = brandRepository.findById(brandId).orElseThrow(() -> ErrorCode.NOT_FOUND_DATA.toException("브랜드"));

		List<RecommendationProduct> result = new ArrayList<>();
		List<Product> productsByBrandId = productRepository.findAllByBrandId(brandId);
		for (Product product : productsByBrandId) {
			Category category = categoryRepository.findById(product.getCategoryId())
												  .orElseThrow(() -> ErrorCode.NOT_FOUND_DATA.toException("카테고리"));
			result.add(RecommendationProduct.builder()
											.id(product.getId())
											.price(product.getPrice())
											.brandId(brandId)
											.brandName(brand.getName())
											.categoryId(category.getId())
											.categoryName(category.getName())
											.build());
		}

		return result;
	}

	@Override
	public MinMaxPriceProducts findMinMaxPriceProducts(String categoryName) {
		Category category = categoryRepository.findByName(categoryName)
											  .orElseThrow(() -> ErrorCode.NOT_FOUND_DATA.toException("카테고리"));

		var maxPriceByCategory = productRecommendationRepository.findMaxPriceByCategory(category.getId());
		bindingBrandName(maxPriceByCategory);
		var minPriceByCategory = productRecommendationRepository.findMinPriceByCategory(category.getId());
		bindingBrandName(minPriceByCategory);

		return MinMaxPriceProducts.builder()
								  .categoryName(categoryName)
								  .minPriceProduct(minPriceByCategory)
								  .maxPriceProduct(maxPriceByCategory)
								  .build();
	}

	private void bindingBrandName(RecommendationProduct maxPriceByCategory) {
		Brand brand = brandRepository.findById(maxPriceByCategory.getBrandId())
									 .orElseThrow(() -> ErrorCode.NOT_FOUND_DATA.toException("브랜드"));
		maxPriceByCategory.changeBrandName(brand.getName());
	}
}
