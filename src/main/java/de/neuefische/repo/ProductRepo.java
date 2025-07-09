package de.neuefische.repo;

import de.neuefische.model.Product;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ProductRepo {
    private final Map<Integer, Product> products = new LinkedHashMap<>();
    private int nextProductId = 1;

    public void addProduct(String productName) {
        Product product = new Product(nextProductId++, productName);
        products.put(product.id(), product);
    }

    public void addProduct(Product product) {
        products.put(product.id(), product);
    }

    public void removeProductById(int id) {
        products.remove(id);
    }

    public Product getProductById(int id) {
        return products.get(id);
    }

    public List<Product> getAllProducts() {
        return new ArrayList<>(products.values());
    }

}
