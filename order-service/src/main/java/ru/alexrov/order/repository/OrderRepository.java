package ru.alexrov.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.alexrov.order.model.Order;

import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, UUID> {
}