package model;

public class OrderItem {
    public Product product;
    public int qty;
    public OrderItem(Product p, int q){ product=p; qty=q; }
    public double subtotal(){ return product.price*qty; }
}
