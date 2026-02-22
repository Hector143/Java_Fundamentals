package Projects;

public class PerishableProduct extends Product {
	private String expire;
	public PerishableProduct(String name, double price, int quantity, String expire) {
		super(name, price, quantity);
		this.expire = expire;
	}
	
	public String getExpire() {
		return expire;
	}

	public void setExpire(String expire) {
		this.expire = expire;
	}

}
