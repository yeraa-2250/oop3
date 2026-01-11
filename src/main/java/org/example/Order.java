package org.example;

import java.time.LocalDate;
import java.util.Objects;

public class Order {

    private int quantity;
    private String status;
    private LocalDate orderDate;
    private Shopper shopper;
    private Product product;

    public Order(Shopper shopper, Product product, int quantity) {
        this.shopper = shopper;
        this.product = product;
        this.quantity = quantity;
        this.status = "CREATED";
        this.orderDate = LocalDate.now();
    }

    public void pay() {
        this.status = "SUCCESSFUL";
        System.out.println("Payment successful for " + product.getName());
    }

    public double getTotalPrice() {
        return product.getPrice() * quantity;
    }

    @Override
    public String toString() {
        return "Order{" +
                "shopper=" + shopper.getName() +
                ", product=" + product.getName() +
                ", quantity=" + quantity +
                ", totalPrice=" + getTotalPrice() +
                ", status='" + status + '\'' +
                ", date=" + orderDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return shopper.equals(order.shopper) &&
                product.equals(order.product) &&
                orderDate.equals(order.orderDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shopper, product, orderDate);
    }
}
