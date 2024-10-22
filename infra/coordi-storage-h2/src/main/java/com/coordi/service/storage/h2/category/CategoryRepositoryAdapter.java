package com.coordi.service.storage.h2.category;

import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coordi.service.application.category.outport.CategoryRepository;
import com.coordi.service.domain.category.Category;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class CategoryRepositoryAdapter implements CategoryRepository {

	private final CategoryJpaRepository jpaRepository;

	@Override
	@Transactional
	public Category create(Category category) {
		CategoryEntity categoryEntity = jpaRepository.save(CategoryDataConverter.toCreateEntity(category));
		return CategoryDataConverter.toModel(categoryEntity);
	}

	@Override
	@Transactional
	public Category update(Category category) {
		var originEntity = jpaRepository.findById(category.getId())
										.orElseThrow(() -> new IllegalArgumentException("카테고리 정보가 없습니다."));
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
		// jpaRepository.deleteById(id);
		jpaRepository.deleteByCategoryId(id, userName);
	}
}
