package org.example;

public class Shopper {
    private String name;
    private String email;
    private String address;

    public Shopper(String name, String email, String address) {
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getAddress() { return address; }

    @Override
    public String toString() {
        return "Shopper{name='" + name + "', email='" + email + "', address='" + address + "'}";
    }
}
