package de.neuefische.service;

import de.neuefische.model.Order;
import de.neuefische.model.OrderItem;
import de.neuefische.model.Product;
import de.neuefische.repo.OrderMapRepo;
import de.neuefische.repo.OrderRepoInterface;
import de.neuefische.repo.ProductRepo;

import java.util.List;
import java.util.Optional;

public class ShopService {
    private final ProductRepo productRepo;
    private final OrderRepoInterface orderRepo;

    public ShopService(ProductRepo productRepo, OrderMapRepo orderRepo) {
        this.productRepo = productRepo;
        this.orderRepo = orderRepo;
    }

    public Optional<Product> getProductById(String id) {
        return productRepo.getProductById(id);
    }

    public void listProducts() {
        for (Product product : productRepo.getAllProducts()) {
            System.out.println(product);
        }
    }

    public void addOrder(List<OrderItem> items) {
        orderRepo.addOrder(items);
    }

    public List<Order> getAllOrders() {
        return orderRepo.getAllOrders();
    }

    public Optional<Order> getOrderById(String id) {
        return orderRepo.getOrderById(id);
    }

    public void listOrders() {
        for (Order order : orderRepo.getAllOrders()) {
            System.out.println(order);
        }
    }
}
