package com.coordi.service.api.adapter.brand;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/brands")
@RequiredArgsConstructor
class BrandController {

	@PostMapping
	public void createBrand() {

	}

	@GetMapping("/{brandId}")
	public void retrieveBrand(@PathVariable String brandId) {

	}

	@PutMapping("/{brandId}")
	public void modifyBrand(@PathVariable String brandId) {

	}

	@DeleteMapping("/{brandId}")
	public void deleteBrand(@PathVariable String brandId) {

	}

}
