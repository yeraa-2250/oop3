package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ShopperRepository {

    public void save(Shopper shopper) throws SQLException {
        String sql = "INSERT INTO shoppers(name, email, address) " +
                "VALUES (?, ?, ?) " +
                "ON CONFLICT(email) DO NOTHING";

        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, shopper.getName());
            ps.setString(2, shopper.getEmail());
            ps.setString(3, shopper.getAddress());
            ps.executeUpdate();
        }
    }

    public void updateAddress(String email, String newAddress) throws SQLException {
        String sql = "UPDATE shoppers SET address = ? WHERE email = ?";

        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, newAddress);
            ps.setString(2, email);
            ps.executeUpdate();
        }
    }

    public Shopper findByEmail(String email) throws SQLException {
        String sql = "SELECT name, email, address FROM shoppers WHERE email = ?";

        try (Connection c = DBConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, email);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Shopper(
                            rs.getString("name"),
                            rs.getString("email"),
                            rs.getString("address")
                    );
                }
            }
        }
        return null;
    }
}
