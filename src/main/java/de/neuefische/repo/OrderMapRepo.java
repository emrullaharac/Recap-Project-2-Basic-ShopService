package de.neuefische.repo;

import de.neuefische.model.Order;
import de.neuefische.model.Product;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class OrderMapRepo implements OrderRepoInterface {
    private Map<Integer, Order> orders = new LinkedHashMap<>();
    private int nextOrderId = 1;

    @Override
    public void addOrder(List<Product> products) {
        Order newOrder = new Order(nextOrderId++, products);
        orders.put(newOrder.id(), newOrder);
    }

    @Override
    public void removeOrder(Order order) {
        orders.remove(order.id());
    }

    @Override
    public void removeOrderById(int id) {
        orders.remove(id);
    }

    @Override
    public Order getOrderById(int id) {
        return orders.get(id);
    }

    @Override
    public List<Order> getAllOrders() {
        return new ArrayList<>(orders.values());
    }
}
