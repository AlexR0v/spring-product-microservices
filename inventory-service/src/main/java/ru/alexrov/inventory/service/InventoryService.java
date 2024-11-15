package ru.alexrov.inventory.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.alexrov.inventory.model.Inventory;
import ru.alexrov.inventory.repository.InventoryRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    public boolean isInStock(String scuCode, Integer quantity) {
        return this.inventoryRepository.existsByScuCodeAndQuantityIsGreaterThanEqual(scuCode, quantity);
    }

    public void changeQuantity(String scuCode, Integer quantity) {
        if(this.isInStock(scuCode, quantity)) {
            Inventory inventory = this.inventoryRepository.findByScuCode(scuCode).orElseThrow(() -> new RuntimeException("Product not found"));
            inventory.setQuantity(inventory.getQuantity() - quantity);
            this.inventoryRepository.save(inventory);
        }
    }

    public List<Inventory> productsInStock() {
        return this.inventoryRepository.findAll();
    }
}
