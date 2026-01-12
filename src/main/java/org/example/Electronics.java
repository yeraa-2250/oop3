package org.example;

import java.sql.SQLException;

public class Electronics {

    public static void main(String[] args) {
        ProductRepository productRepo = new ProductRepository();

        try {
            Product iphone = new Product("iPhone 17 Pro Max", 982000, "Electronics");
            Product macbook = new Product("MacBook Pro", 1500000, "Electronics");

            productRepo.save(iphone);
            productRepo.save(macbook);

            System.out.println("Products inserted/updated successfully.\n");

            System.out.println("Products in DB:");
            for (Product p : productRepo.findAll()) {
                System.out.println(p.getName() + " | " + p.getCategory() + " | $" + p.getPrice());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
