package ru.alexrov.product.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.alexrov.product.dto.ProductDtoRequest;
import ru.alexrov.product.dto.ProductDtoResponse;
import ru.alexrov.product.mappers.ProductMapper;
import ru.alexrov.product.repository.ProductRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public List<ProductDtoResponse> getProducts() {
        List<ProductDtoResponse> productDtoResponse = this.productRepository.findAll().stream().map(this.productMapper::entityToDtoResponse).toList();
        log.info("products: {}", productDtoResponse);
        return productDtoResponse;
    }

    public ProductDtoResponse createProduct(ProductDtoRequest productDtoRequest) {
        ProductDtoResponse productDtoResponse = this.productMapper.entityToDtoResponse(this.productRepository.save(this.productMapper.requestDtoToEntity(productDtoRequest)));
        log.info("product: {}", productDtoResponse);
        return productDtoResponse;
    }
}
