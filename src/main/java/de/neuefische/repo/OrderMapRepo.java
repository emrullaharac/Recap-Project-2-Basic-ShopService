package de.neuefische.repo;

import de.neuefische.model.Order;
import de.neuefische.model.OrderItem;
import de.neuefische.model.Product;

import java.util.*;

public class OrderMapRepo implements OrderRepoInterface {
    private final Map<String, Order> orders = new LinkedHashMap<>();

    @Override
    public void addOrder(List<OrderItem> items) {
        Order newOrder = new Order(UUID.randomUUID().toString(), items);
        orders.put(newOrder.id(), newOrder);
    }

    @Override
    public void removeOrder(Order order) {
        orders.remove(order.id());
    }

    @Override
    public void removeOrderById(String id) {
        orders.remove(id);
    }

    @Override
    public Optional<Order> getOrderById(String id) {
        return Optional.ofNullable(orders.get(id));
    }

    @Override
    public List<Order> getAllOrders() {
        return new ArrayList<>(orders.values());
    }
}
