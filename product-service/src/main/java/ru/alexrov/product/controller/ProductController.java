package ru.alexrov.product.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.alexrov.product.dto.ProductDtoRequest;
import ru.alexrov.product.dto.ProductDtoResponse;
import ru.alexrov.product.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
@Tag(name = "Products")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductDtoResponse>> getProducts() {
        return ResponseEntity.ok(this.productService.getProducts());
    }

    @PostMapping("/create")
    public ResponseEntity<ProductDtoResponse> createProduct(@RequestBody ProductDtoRequest productDtoRequest) {
        return ResponseEntity.ok(this.productService.createProduct(productDtoRequest));
    }

}

