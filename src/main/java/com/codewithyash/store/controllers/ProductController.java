package com.codewithyash.store.controllers;

import java.util.List;
import java.util.Set;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewithyash.store.dtos.ProductDto;
import com.codewithyash.store.mappers.ProductMapper;
import com.codewithyash.store.repositories.ProductRepository;

import lombok.AllArgsConstructor;

import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@AllArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @GetMapping
    public List<ProductDto> getAllProducts(
            @RequestParam(required = false) Byte categoryId,
            /**
             * required = false, defaultValue = "",name = "sortBy"
             * This parameter allows the client to specify the sorting criteria for the
             * products.
             * If not provided, it defaults to an empty string.
             */
            @RequestParam(required = false, defaultValue = "", name = "sortBy") String sort

    ) {
        if (!Set.of("name", "id", "description", "price").contains(sort)) {
            sort = "id"; // Default sort by name if invalid sort parameter is provided
        }
        // This method will be implemented later to return all products
        var products = productRepository
                .findAll(Sort.by(sort))
                .stream()
                .map(product -> productMapper.toDto(product))
                .filter(productdto -> categoryId == null || categoryId.equals(productdto.getCategoryId()))
                .toList();

        return products; // Placeholder return statement
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable Long id) {
        var product = productRepository.findById(id).orElse(null);
        if (product == null) {
            return ResponseEntity.notFound().build(); // Return 404 Not Found if product does not exist
        }
        var productDto = productMapper.toDto(product);
        return ResponseEntity.ok(productDto); // Return 200 OK with the product details
    }
}
