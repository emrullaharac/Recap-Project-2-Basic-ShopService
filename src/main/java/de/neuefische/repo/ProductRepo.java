package de.neuefische.repo;

import de.neuefische.model.Product;

import java.util.*;

public class ProductRepo {
    private final Map<String, Product> products = new LinkedHashMap<>();

    public void addProduct(String productName) {
        Product product = new Product(UUID.randomUUID().toString(), productName);
        products.put(product.id(), product);
    }

    public void addProduct(Product product) {
        products.put(product.id(), product);
    }

    public void removeProductById(String id) {
        products.remove(id);
    }

    public Product getProductById(String id) {
        return products.get(id);
    }

    public List<Product> getAllProducts() {
        return new ArrayList<>(products.values());
    }

}
