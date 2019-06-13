package com.calicomaru.rabbitmqdemo.model;

public class Fruit {

    private String name;
    private double price;

    public Fruit() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Fruit(String name, double price) {
        this.name = name;
        this.price = price;
    }
}
