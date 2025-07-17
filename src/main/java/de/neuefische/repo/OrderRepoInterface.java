package de.neuefische.repo;

import de.neuefische.model.Order;
import de.neuefische.model.Product;

import java.util.List;
import java.util.Optional;

public interface OrderRepoInterface {
    void addOrder(List<Product> products);
    void removeOrder(Order order);
    void removeOrderById(String id);
    Optional<Order> getOrderById(String id);
    List<Order> getAllOrders();
}
