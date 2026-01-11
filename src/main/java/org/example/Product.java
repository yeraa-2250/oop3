package org.example;

import java.util.Objects;

public abstract class Product {

    private String name;
    private double price;

    protected Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public abstract String getCategory();

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return name + " | " + getCategory() + " | $" + price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return name.equals(product.name) &&
                getCategory().equals(product.getCategory());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, getCategory());
    }
}
