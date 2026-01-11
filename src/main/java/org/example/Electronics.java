package org.example;

public class Electronics extends Product {

    public Electronics(String name, double price) {
        super(name, price);
    }

    @Override
    public String getCategory() {
        return "Electronics";
    }
}
