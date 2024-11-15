package ru.alexrov.inventory.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.alexrov.inventory.model.Inventory;
import ru.alexrov.inventory.service.InventoryService;

import java.util.List;

@RestController
@RequestMapping("/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping
    public boolean isInStock(@RequestParam String scuCode, @RequestParam Integer quantity) {
        return this.inventoryService.isInStock(scuCode, quantity);
    }

    @GetMapping("/changeQuantity")
    public void changeQuantity(@RequestParam String scuCode, @RequestParam Integer quantity) {
        this.inventoryService.changeQuantity(scuCode, quantity);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Inventory>> getAllProductsInStock() {
        return ResponseEntity.ok(this.inventoryService.productsInStock());
    }
}
