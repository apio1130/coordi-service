package com.coordi.service.api.adapter.product;

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

import com.coordi.service.application.product.port.in.ProductUseCase;
import com.coordi.service.domain.product.Product;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/products")
@RequiredArgsConstructor
class ProductController {

	private final ProductUseCase productService;

	@GetMapping("/{productId}")
	public ResponseEntity<ProductResponse> retrieveProduct(@PathVariable Long productId) {
		Optional<ProductResponse> product = productService.findById(productId).map(ProductResponse::from);
		return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<ProductResponse> createProduct(@RequestBody ProductRequest productRequest) {
		Product product = productService.create(ProductCommandConverter.toCreate(productRequest));
		return ResponseEntity.created(URI.create("/v1/products/%s".formatted(product.getId())))
							 .body(ProductResponse.from(product));
	}

	@PutMapping("/{productId}")
	public ResponseEntity<ProductResponse> modifyProduct(@PathVariable Long productId,
														 @RequestBody ProductRequest productRequest) {
		Product product = productService.update(ProductCommandConverter.toUpdate(productRequest, productId));
		return ResponseEntity.ok(ProductResponse.from(product));
	}

	@DeleteMapping("/{productId}")
	public void deleteProduct(@PathVariable Long productId, @RequestParam String userName) {
		productService.delete(productId, userName);
	}

}
