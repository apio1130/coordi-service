package com.coordi.service.storage.adapter.product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

interface ProductJpaRepository extends JpaRepository<ProductEntity, Long> {

	@Modifying(clearAutomatically = true)
	@Query("update ProductEntity p set p.useYn = 'N', p.modifiedAt = now(), p.modifiedBy = :userName "
		  + "where p.id = :productId and p.useYn = 'Y'")
	int deleteById(Long productId, String userName);

	List<ProductEntity> findAllByBrandId(Long brandId);
}
