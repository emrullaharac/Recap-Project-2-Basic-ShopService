package de.neuefische.repo;

import de.neuefische.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepoTest {
    private ProductRepo repo;

    @BeforeEach
    void setUp() {
        repo = new ProductRepo();
    }

    @Test
    void addProduct() {
        Product p = new Product("id1", "Apfel", 1.5);
        repo.addProduct(p);

        Product found = repo.getProductById("id1").isPresent() ? repo.getProductById("id1").get() : null;

        assertEquals(p, found);
    }

    @Test
    void removeProductById() {
        Product p = new Product("id1", "Apfel", 1.5);
        repo.addProduct(p);
        repo.removeProductById("id1");
        assertTrue(repo.getProductById("id1").isEmpty());
    }

    @Test
    void getProductById() {
        Product p = new Product("id1", "Apfel", 1.5);
        repo.addProduct(p);
        Product found = repo.getProductById("id1").isPresent() ? repo.getProductById("id1").get() : null;
        assertEquals(p, found);
    }

    @Test
    void getAllProducts() {
        Product p1 = new Product("id1", "Apfel", 1.5);
        Product p2 = new Product("id2", "Birne", 3);
        repo.addProduct(p1);
        repo.addProduct(p2);

        List<Product> products = repo.getAllProducts();
        assertTrue(repo.getProductById("id1").isPresent());
        assertTrue(repo.getProductById("id2").isPresent());

        assertEquals(p1, repo.getProductById("id1").get());
        assertEquals(p2, repo.getProductById("id2").get());
    }
}