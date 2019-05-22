package com.example.e_market;

public class Book {
    private String name;
    private String description;
    private String price;
    private String photo;

    public Book(String name, String description, String price, String photo){
        this.name = name;
        this.description = description;
        this.price = price;
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getPrice() {
        return price;
    }

    public String getPhoto() {
        return photo;
    }
}
