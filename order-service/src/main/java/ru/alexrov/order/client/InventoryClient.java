package ru.alexrov.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "inventory", url = "${inventory.url}")
public interface InventoryClient {

    @GetMapping("/inventory")
    public boolean isInStock(@RequestParam String scuCode, @RequestParam Integer quantity);

    @GetMapping("/inventory/changeQuantity")
    public void changeQuantity(@RequestParam String scuCode, @RequestParam Integer quantity);
}
