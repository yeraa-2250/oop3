package org.example;

import java.util.Objects;

public class Shopper {

    private String name;
    private String email;
    private String address;

    public Shopper(String name, String email, String address) {
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Shopper{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Shopper)) return false;
        Shopper shopper = (Shopper) o;
        return email.equals(shopper.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
}
