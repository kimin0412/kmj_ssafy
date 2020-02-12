package Abc;

public class Refrigerator extends Product {
	private int capacity;
	
	public Refrigerator() {}

	public Refrigerator(int num, String model, int price, int stock, int capacity) {
		super(num, model, price, stock);
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		return "Refrigerator [num=" + this.getNum() + ", model=" + this.getModel() + 
				", price=" + this.getPrice() + ", stock=" + this.getStock() + 
				", capacity=" + capacity + "]";
	}
	
}
