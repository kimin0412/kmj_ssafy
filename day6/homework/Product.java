package Abc;

public class Product {
	private int num;
	private String model;
	private int price;
	private int stock;

	public Product() {}

	public Product(int num, String model, int price, int stock) {
		super();
		this.num = num;
		this.model = model;
		this.price = price;
		this.stock = stock;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		if (price >= 0) {
			this.price = price;
		} else {
			System.out.println("치량 가격은 0원 이상으로 설정하세요.");
		}
	}
	
	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Product [num=" + num + ", model=" + model + ", price=" + price + ""
				+ ", stock=" + stock + "]";
	}
	
}
