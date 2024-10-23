package com.coordi.service.api.adapter.product;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/v1/products")
@RequiredArgsConstructor
class ProductController {

	@PostMapping
	public void createProduct() {

	}

	@GetMapping("/{productId}")
	public void retrieveProduct(@PathVariable String productId) {
		log.info("Retrieving product {}", productId);
	}

	@PutMapping("/{productId}")
	public void modifyProduct(@PathVariable String productId) {

	}

	@DeleteMapping("/{productId}")
	public void deleteProduct(@PathVariable String productId) {

	}

}
