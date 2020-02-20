package hw;

public class TV extends Product {
	private int inch;
	
	public TV() {}

	public TV(int num, String model, int price, int stock, int inch) {
		super(num, model, price, stock);
		this.inch = inch;
	}

	public int getInch() {
		return inch;
	}

	public void setInch(int inch) {
		this.inch = inch;
	}

	@Override
	public String toString() {
		return "TV [num=" + this.getNum() + ", model=" + this.getModel() + 
				", price=" + this.getPrice() + ", stock=" + this.getStock() + 
				", inch=" + inch + "]";
	}
	
	
	
}
