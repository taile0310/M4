package com.example.model;

public class Product {
    private int id;
    private String name;
    private String describe;
    private String producer;
        private double prices;

    public Product() {
    }

    public Product(int id, String name, String describe, String producer, double prices) {
        this.id = id;
        this.name = name;
        this.describe = describe;
        this.producer = producer;
        this.prices = prices;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public double getPrices() {
        return prices;
    }

    public void setPrices(double prices) {
        this.prices = prices;
    }
}
