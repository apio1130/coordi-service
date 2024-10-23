package com.coordi.service.storage.adapter.category;

import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coordi.service.application.category.port.out.CategoryRepository;
import com.coordi.service.application.common.exception.ErrorCode;
import com.coordi.service.domain.category.Category;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class CategoryRepositoryAdapter implements CategoryRepository {

	private final CategoryJpaRepository jpaRepository;

	@Override
	@Transactional
	public Category create(Category category) {
		jpaRepository.findByName(category.getName()).ifPresent(c -> {
			throw ErrorCode.DUPLICATE_KEY.toException("카테고리명");
		});
		CategoryEntity categoryEntity = jpaRepository.save(CategoryDataConverter.toCreateEntity(category));
		return CategoryDataConverter.toModel(categoryEntity);
	}

	@Override
	@Transactional
	public Category update(Category category) {
		var originEntity = jpaRepository.findById(category.getId())
										.orElseThrow(() -> ErrorCode.NOT_FOUND_DATA.toException("카테고리"));
		jpaRepository.findByName(category.getName()).ifPresent(c -> {
			if (!c.getId().equals(category.getId())) {
				throw ErrorCode.DUPLICATE_KEY.toException("카테고리명");
			}
		});
		CategoryEntity categoryEntity = jpaRepository.save(CategoryDataConverter.toUpdateEntity(originEntity, category));
		return CategoryDataConverter.toModel(categoryEntity);
	}

	@Override
	public Optional<Category> findById(Long id) {
		return jpaRepository.findById(id).map(CategoryDataConverter::toModel);
	}

	@Override
	@Transactional
	public void deleteById(Long id, String userName) {
		jpaRepository.deleteById(id, userName);
	}
}
