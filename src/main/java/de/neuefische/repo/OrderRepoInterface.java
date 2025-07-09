package de.neuefische.repo;

import de.neuefische.model.Order;
import de.neuefische.model.Product;

import java.util.List;

public interface OrderRepoInterface {
    void addOrder(List<Product> products);
    void removeOrder(Order order);
    void removeOrderById(int id);
    Order getOrderById(int id);
    List<Order> getAllOrders();
}
