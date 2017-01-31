package com.ironyard.data;

/**
 * Created by jasonskipper on 1/31/17.
 * */
public class GroceryItem {
    private long id;
    private double price;
    private String name;
    private String category;
    private int isle;

    public GroceryItem() {
    }

    public GroceryItem(double price, String name, String category, int isle) {
        this.price = price;
        this.name = name;
        this.category = category;
        this.isle = isle;
    }

    public GroceryItem(long id, double price, String name, String category, int isle) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.category = category;
        this.isle = isle;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getIsle() {
        return isle;
    }

    public void setIsle(int isle) {
        this.isle = isle;
    }
}
