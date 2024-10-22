package com.coordi.service.api.category;

import java.net.URI;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.coordi.service.application.category.usecase.CategoryUseCase;
import com.coordi.service.domain.category.Category;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/categories")
@RequiredArgsConstructor
public class CategoryController {

	private final CategoryUseCase categoryUseCase;

	@GetMapping("/{categoryId}")
	public ResponseEntity<CategoryResponse> retrieveCategory(@PathVariable Long categoryId) {
		Optional<CategoryResponse> category = categoryUseCase.findById(categoryId).map(CategoryResponse::from);
		return category.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<CategoryResponse> createCategory(@RequestBody CategoryRequest categoryRequest) {
		Category category = categoryUseCase.create(CategoryCommandConverter.toCreate(categoryRequest));
		return ResponseEntity.created(URI.create("/v1/categories/%s".formatted(category.getId())))
							 .body(CategoryResponse.from(category));
	}

	@PutMapping("/{categoryId}")
	public CategoryResponse modifyCategory(@PathVariable Long categoryId,
										   @RequestBody CategoryRequest categoryRequest) {
		Category category = categoryUseCase.update(CategoryCommandConverter.toUpdate(categoryRequest, categoryId));
		return CategoryResponse.from(category);
	}

	@DeleteMapping("/{categoryId}")
	public void deleteCategory(@PathVariable Long categoryId, @RequestParam String userName) {
		categoryUseCase.delete(categoryId, userName);
	}

}
