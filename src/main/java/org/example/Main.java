import org.example.*;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Product phone = new Electronics("iPhone 17 Pro Max", 982000);
        Product laptop = new Electronics("MacBook Pro", 1500000);

        List<Product> products = new ArrayList<>();
        products.add(phone);
        products.add(laptop);

        Shopper shopper = new Shopper(
                "Yernur",
                "ernur@gmail.com",
                "Kabanbay 60a/13"
        );

        Order order = new Order(shopper, phone, 1);
        order.pay();

        System.out.println("\nSorted by price:");
        products.stream()
                .sorted((p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()))
                .forEach(System.out::println);

        System.out.println("\nOnly electronics:");
        products.stream()
                .filter(p -> p.getCategory().equalsIgnoreCase("Electronics"))
                .forEach(System.out::println);

        Product found = products.stream()
                .filter(p -> p.getName().equalsIgnoreCase("MacBook Pro"))
                .findFirst()
                .orElse(null);
        System.out.println("\nSearch result: " + found);
    }
}
