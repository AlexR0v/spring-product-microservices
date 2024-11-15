package ru.alexrov.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.alexrov.inventory.model.Inventory;

import java.util.Optional;

public interface InventoryRepository extends JpaRepository<Inventory, Integer> {

    boolean existsByScuCodeAndQuantityIsGreaterThanEqual(String scuCode, Integer quantity);

    Optional<Inventory> findByScuCode(String scuCode);
}