package ru.alexrov.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.alexrov.product.model.Product;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
}