package com.coordi.service.storage.adapter.brand;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

interface BrandJpaRepository extends JpaRepository<BrandEntity, Long> {

	@Modifying(clearAutomatically = true)
	@Query("update BrandEntity b set b.useYn = 'N', b.modifiedAt = now(), b.modifiedBy = :userName "
		 + "where b.id = :brandId and b.useYn = 'Y'")
	int deleteById(Long brandId, String userName);

	Optional<BrandEntity> findByName(String name);
}
