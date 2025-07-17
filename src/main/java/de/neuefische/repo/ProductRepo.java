package de.neuefische.repo;

import de.neuefische.model.Product;

import java.util.*;

public class ProductRepo {
    private final Map<String, Product> products = new LinkedHashMap<>();

    public void addProduct(String productName) {
        Product product = new Product(UUID.randomUUID().toString(), productName, 0.0);
        products.put(product.id(), product);
    }

    public void addProduct(Product product) {
        products.put(product.id(), product);
    }

    public void removeProductById(String id) {
        products.remove(id);
    }

    public Optional<Product> getProductById(String id) {
        return Optional.ofNullable(products.get(id));
    }

    public List<Product> getAllProducts() {
        return new ArrayList<>(products.values());
    }

}
