package de.neuefische.model;

import lombok.With;

import java.util.List;

@With
public record Order(String id, List<OrderItem> items) {
    public double getTotalPrice() {
        return items.stream()
                .mapToDouble(o -> o.quantity() * o.product().price())
                .sum();
    }
}