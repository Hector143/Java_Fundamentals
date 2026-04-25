package CCE_103;

public class Item {
    private String name;
    private double price;
    private int stock;

    public Item(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getStock() { return stock; }
    
    public void setStock(int stock) {
        this.stock = stock;
    }
    public void reduceStock() {
    	stock--; 
    }
    public void addStock(int qty) {
        this.stock += qty;
    }
    public String toFileString() {
        return name + "|" + price + "|" + stock;
    }
}