package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {

    public void save(Product product) throws SQLException {
        String sql = "INSERT INTO products(name, price, category) " +
                "VALUES (?, ?, ?) " +
                "ON CONFLICT(name) DO UPDATE SET price = EXCLUDED.price, category = EXCLUDED.category";

        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, product.getName());
            ps.setDouble(2, product.getPrice());
            ps.setString(3, product.getCategory());
            ps.executeUpdate();
        }
    }

    public void updatePrice(String productName, double newPrice) throws SQLException {
        String sql = "UPDATE products SET price = ? WHERE name = ?";

        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setDouble(1, newPrice);
            ps.setString(2, productName);
            ps.executeUpdate();
        }
    }

    public void deleteByName(String productName) throws SQLException {
        String sql = "DELETE FROM products WHERE name = ?";

        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, productName);
            ps.executeUpdate();
        }
    }

    public List<Product> findAll() throws SQLException {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT name, price, category FROM products";

        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                products.add(new Product(
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getString("category")
                ));
            }
        }
        return products;
    }
}
