package com.coordi.service.storage.adapter.brand;

import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coordi.service.application.brand.port.out.BrandRepository;
import com.coordi.service.application.common.exception.ErrorCode;
import com.coordi.service.domain.brand.Brand;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class BrandRepositoryAdapter implements BrandRepository {

	private final BrandJpaRepository jpaRepository;

	@Override
	@Transactional
	public Brand create(Brand category) {
		jpaRepository.findByName(category.getName()).ifPresent(c -> {
			throw ErrorCode.DUPLICATE_KEY.toException("브랜드명");
		});
		BrandEntity categoryEntity = jpaRepository.save(BrandDataConverter.toCreateEntity(category));
		return BrandDataConverter.toModel(categoryEntity);
	}

	@Override
	@Transactional
	public Brand update(Brand category) {
		var originEntity = jpaRepository.findById(category.getId())
										.orElseThrow(() -> ErrorCode.NOT_FOUND_DATA.toException("브랜드"));
		jpaRepository.findByName(category.getName()).ifPresent(c -> {
			if (!c.getId().equals(category.getId())) {
				throw ErrorCode.DUPLICATE_KEY.toException("브랜드명");
			}
		});
		BrandEntity categoryEntity = jpaRepository.save(BrandDataConverter.toUpdateEntity(originEntity, category));
		return BrandDataConverter.toModel(categoryEntity);
	}

	@Override
	public Optional<Brand> findById(Long id) {
		return jpaRepository.findById(id).map(BrandDataConverter::toModel);
	}

	@Override
	@Transactional
	public void deleteById(Long id, String userName) {
		jpaRepository.deleteById(id, userName);
	}
}
