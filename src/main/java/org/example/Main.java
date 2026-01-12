package org.example;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        ProductRepository productRepo = new ProductRepository();
        ShopperRepository shopperRepo = new ShopperRepository();

        try {
            productRepo.save(new Product("iPhone 17 Pro Max", 982000, "Electronics"));
            productRepo.save(new Product("MacBook Pro", 1500000, "Electronics"));

            System.out.println("Inserted data into DB.\n");

            System.out.println("Products in DB:");
            for (Product p : productRepo.findAll()) {
                System.out.println(p.getName() + " | " + p.getCategory() + " | $" + p.getPrice());
            }

            shopperRepo.save(new Shopper("Yernur", "ernur@gmail.com", "Kabanbay 60a/13"));

            System.out.println("\nShoppers in DB:");
            System.out.println(shopperRepo.findByEmail("ernur@gmail.com"));

            productRepo.updatePrice("MacBook Pro", 1450000);
            shopperRepo.updateAddress("ernur@gmail.com", "Astana");

            System.out.println("\nAfter updates:");
            for (Product p : productRepo.findAll()) {
                System.out.println(p.getName() + " | " + p.getCategory() + " | $" + p.getPrice());
            }
            System.out.println(shopperRepo.findByEmail("ernur@gmail.com"));

            productRepo.deleteByName("MacBook Pro");
            System.out.println("\nAfter deletion:");
            for (Product p : productRepo.findAll()) {
                System.out.println(p.getName() + " | " + p.getCategory() + " | $" + p.getPrice());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
