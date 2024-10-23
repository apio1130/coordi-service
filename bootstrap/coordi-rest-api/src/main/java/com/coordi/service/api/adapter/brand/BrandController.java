package com.coordi.service.api.adapter.brand;

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

import com.coordi.service.application.brand.port.in.BrandUseCase;
import com.coordi.service.domain.brand.Brand;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/brands")
@RequiredArgsConstructor
class BrandController {

	private final BrandUseCase brandService;

	@GetMapping("/{brandId}")
	public ResponseEntity<BrandResponse> retrieveBrand(@PathVariable Long brandId) {
		Optional<BrandResponse> brand = brandService.findById(brandId).map(BrandResponse::from);
		return brand.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<BrandResponse> createBrand(@RequestBody BrandRequest brandRequest) {
		Brand brand = brandService.create(BrandCommandConverter.toCreate(brandRequest));
		return ResponseEntity.created(URI.create("/v1/brands/%s".formatted(brand.getId())))
							 .body(BrandResponse.from(brand));
	}
	@PutMapping("/{brandId}")
	public ResponseEntity<BrandResponse> modifyBrand(@PathVariable Long brandId,
													 @RequestBody BrandRequest brandRequest) {
		Brand brand = brandService.update(BrandCommandConverter.toUpdate(brandRequest, brandId));
		return ResponseEntity.ok(BrandResponse.from(brand));
	}

	@DeleteMapping("/{brandId}")
	public void deleteBrand(@PathVariable Long brandId, @RequestParam String userName) {
		brandService.delete(brandId, userName);
	}

}
