package de.neuefische.model;

import java.util.List;

public record Order(int id, List<Product> products) { }