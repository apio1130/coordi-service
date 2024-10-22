package com.coordi.service.storage.h2.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface CategoryJpaRepository extends JpaRepository<CategoryEntity, Long> {

	@Modifying(clearAutomatically = true)
	@Query("update CategoryEntity c set c.useYn = 'N', c.modifiedAt = now(), c.modifiedBy = :userName "
		  + "where c.id = :categoryId and c.useYn = 'Y'")
	int deleteByCategoryId(Long categoryId, String userName);
}
