package de.neuefische.repo;

import de.neuefische.model.Order;
import de.neuefische.model.Product;

import java.util.*;

public class OrderListRepo implements OrderRepoInterface {
    private List<Order> orders = new ArrayList<>();

    @Override
    public void addOrder(List<Product> products) {
        Order newOrder = new Order(UUID.randomUUID().toString(), products);
        orders.add(newOrder);
    }

    @Override
    public void removeOrder(Order order) {
        orders.remove(order);
    }

    @Override
    public void removeOrderById(String id) {
        orders.removeIf(order -> Objects.equals(order.id(), id));
    }

    @Override
    public Optional<Order> getOrderById(String id) {
        for (Order order : orders) {
            if (Objects.equals(order.id(), id)) {
                return order;
            }
        }
        return null;
    }

    @Override
    public List<Order> getAllOrders() {
        return orders;
    }
}
