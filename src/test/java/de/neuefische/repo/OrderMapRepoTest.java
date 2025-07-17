package de.neuefische.repo;

import de.neuefische.model.Order;
import de.neuefische.model.OrderItem;
import de.neuefische.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class OrderMapRepoTest {
    private OrderMapRepo repo;
    private List<OrderItem> orderItems;

    @BeforeEach
    void setUp() {
        repo = new OrderMapRepo();

        Product p1 = new Product("id1", "Apfel", 1.5);
        Product p2 = new Product("id2", "Birne", 3);
        OrderItem item1 = new OrderItem(p1, 1);
        OrderItem item2 = new OrderItem(p2, 2);
        orderItems = List.of(item1, item2);
    }

    @Test
    void addOrder() {
        Order order = new Order("id-1", orderItems);
        repo.addOrder(order);

        Optional<Order> order1 = repo.getOrderById("id-1");

        assertTrue(order1.isPresent());
        assertEquals(order, order1.get());
    }

    @Test
    void removeOrder() {
        Order order = new Order("id-1", orderItems);
        repo.addOrder(order);
        repo.removeOrder(order);
        Optional<Order> order1 = repo.getOrderById("id-1");
        assertTrue(order1.isEmpty());
    }

    @Test
    void removeOrderById() {
        Order order = new Order("id-1", orderItems);
        repo.addOrder(order);
        repo.removeOrderById("id-1");
        Optional<Order> order1 = repo.getOrderById("id-1");
        assertTrue(order1.isEmpty());
    }

    @Test
    void getOrderById() {
        Order order = new Order("id-1", orderItems);
        repo.addOrder(order);
        Optional<Order> order1 = repo.getOrderById("id-1");
        assertTrue(order1.isPresent());
        assertEquals(order, order1.get());
    }

    @Test
    void getAllOrders() {
        Order order = new Order("id-1", orderItems);
        Order order2 = new Order("id-2", orderItems);
        repo.addOrder(order);
        repo.addOrder(order2);

        List<Order> orders = repo.getAllOrders();
        assertTrue(orders.contains(order));
        assertTrue(orders.contains(order2));
    }
}