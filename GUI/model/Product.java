package model;

public class Product {
    public int id, stock;
    public String name;
    public double price;
    public Product(int id, String name, int stock, double price){
        this.id=id; this.name=name; this.stock=stock; this.price=price;
    }
}
