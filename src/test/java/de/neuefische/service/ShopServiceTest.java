package de.neuefische.service;

import de.neuefische.model.Order;
import de.neuefische.model.OrderItem;
import de.neuefische.model.Product;
import de.neuefische.repo.OrderMapRepo;
import de.neuefische.repo.ProductRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class ShopServiceTest {
    private ShopService shopService;
    private OrderMapRepo orderMapRepo;
    private ProductRepo productRepo;

    @BeforeEach
    void setUp() {
        productRepo = new ProductRepo();
        orderMapRepo = new OrderMapRepo();
        shopService = new ShopService(productRepo, orderMapRepo);

        Product p1 = new Product("id1", "Apfel", 1.5);
        Product p2 = new Product("id2", "Birne", 2.0);
        productRepo.addProduct(p1);
        productRepo.addProduct(p2);
    }

    @Test
    void getProductById() {
        Optional<Product> product = shopService.getProductById("id1");
        assertThat(product).isPresent();
        assertThat(product.get().name()).isEqualTo("Apfel");
    }

    @Test
    void listProducts() {
        assertThat(productRepo.getAllProducts()).hasSize(2);
    }

    @Test
    void addOrder_and_getOrderById() {
        Product p1 = productRepo.getProductById("id1").orElseThrow();
        Product p2 = productRepo.getProductById("id2").orElseThrow();
        OrderItem item1 = new OrderItem(p1, 1);
        OrderItem item2 = new OrderItem(p2, 3);
        List<OrderItem> items = List.of(item1, item2);

        shopService.addOrder(items);

        List<Order> allOrders = shopService.getAllOrders();
        assertThat(allOrders).hasSize(1);

        Order order = allOrders.getFirst();
        assertThat(order.items()).containsExactly(item1, item2);


        Optional<Order> orderOpt = shopService.getOrderById(order.id());
        assertThat(orderOpt).isPresent();
        assertThat(orderOpt.get()).isEqualTo(order);
    }

    @Test
    void listOrders() {
        Product p1 = productRepo.getProductById("id1").orElseThrow();
        OrderItem item = new OrderItem(p1, 2);
        shopService.addOrder(List.of(item));

        List<Order> allOrders = shopService.getAllOrders();
        assertThat(allOrders).hasSize(1);
    }
}