package com.coordi.service.storage.adapter.category;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

interface CategoryJpaRepository extends JpaRepository<CategoryEntity, Long> {

	@Modifying(clearAutomatically = true)
	@Query("update CategoryEntity c set c.useYn = 'N', c.modifiedAt = now(), c.modifiedBy = :userName "
		  + "where c.id = :categoryId and c.useYn = 'Y'")
	int deleteById(Long categoryId, String userName);

	Optional<CategoryEntity> findByName(String name);
}
