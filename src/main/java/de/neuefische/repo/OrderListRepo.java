package de.neuefische.repo;

import de.neuefische.model.Order;
import de.neuefische.model.Product;

import java.util.ArrayList;
import java.util.List;

public class OrderListRepo implements OrderRepoInterface {
    private List<Order> orders = new ArrayList<>();
    private int nextOrderId = 1;

    @Override
    public void addOrder(List<Product> products) {
        Order newOrder = new Order(nextOrderId++, products);
        orders.add(newOrder);
    }

    @Override
    public void removeOrder(Order order) {
        orders.remove(order);
    }

    @Override
    public void removeOrderById(int id) {
        orders.removeIf(order -> order.id() == id);
    }

    @Override
    public Order getOrderById(int id) {
        for (Order order : orders) {
            if (order.id() == id) {
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
