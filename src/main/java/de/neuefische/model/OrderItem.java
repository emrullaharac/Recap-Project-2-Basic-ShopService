package de.neuefische.model;

import lombok.With;

@With
public record OrderItem(Product product, int quantity) {
}
