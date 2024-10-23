package com.coordi.service.storage.adapter.product;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRecommendationJpaRepository extends JpaRepository<ProductEntity, Long> {

	@Query(value = "SELECT P.BRAND_ID, MIN(P.PRICE) AS PRICE FROM PRODUCT P WHERE P.CATEGORY_ID = :categoryId "
				 + "GROUP BY P.BRAND_ID ORDER BY MIN(P.PRICE) ASC LIMIT 1", nativeQuery = true)
	Optional<ProductInfo> findMinPriceByCategory(Long categoryId);

	@Query(value = "SELECT P.BRAND_ID, MIN(P.PRICE) AS PRICE FROM PRODUCT P WHERE P.CATEGORY_ID = :categoryId "
				 + "GROUP BY P.BRAND_ID ORDER BY MIN(P.PRICE) DESC LIMIT 1", nativeQuery = true)
	Optional<ProductInfo> findMaxPriceByCategory(Long categoryId);

	@Query(value = "SELECT P.CATEGORY_ID, MIN(P.PRICE) AS PRICE FROM PRODUCT P WHERE P.BRAND_ID = :brandId "
				 + "GROUP BY P.CATEGORY_ID ORDER BY MIN(P.PRICE) ASC LIMIT 1", nativeQuery = true)
	Optional<ProductInfo> findMinPriceByBrand(Long brandId);

	@Query(value = "SELECT P.BRAND_ID, SUM(P.PRICE) AS PRICE FROM PRODUCT P "
				 + "GROUP BY P.BRAND_ID ORDER BY MIN(P.PRICE) ASC LIMIT 1", nativeQuery = true)
	Optional<ProductInfo> findTopByMinTotalPriceBrand();
}
