package com.company;

import java.util.Objects;

public class Product {
    private String name;
    private int price;
    private int quantity;
    private boolean equals;


    public Product(String name, int price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public Product() {
    }

    public String toString() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }


    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return price == product.price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, quantity, equals);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}







