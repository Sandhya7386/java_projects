package com.gqt_java.java_gqt.project2;
class Product {
    String name;
    String company;
    String details;
    int price;

    Product(String name, String company, String details, int price) {
        this.name = name;
        this.company = company;
        this.details = details;
        this.price = price;
    }

    void display(int index) {
        System.out.println(index + ". " + name + " | " + company +
                " | " + details + " | ₹" + price);
    }
}
