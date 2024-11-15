package ru.alexrov.product.mappers;

import org.springframework.stereotype.Component;
import ru.alexrov.product.dto.ProductDtoRequest;
import ru.alexrov.product.dto.ProductDtoResponse;
import ru.alexrov.product.model.Product;

@Component
public class ProductMapper {

    public Product requestDtoToEntity(ProductDtoRequest productDtoRequest){
        return Product.builder()
                .name(productDtoRequest.getName())
                .description(productDtoRequest.getDescription())
                .price(productDtoRequest.getPrice())
                .build();
    }

    public Product responseDtoToEntity(ProductDtoResponse productDtoResponse){
        return Product.builder()
                .name(productDtoResponse.getName())
                .description(productDtoResponse.getDescription())
                .price(productDtoResponse.getPrice())
                .build();
    }

    public ProductDtoRequest entityToDtoRequest(Product product){
        return ProductDtoRequest.builder()
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
    public ProductDtoResponse entityToDtoResponse(Product product){
        return ProductDtoResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }

}