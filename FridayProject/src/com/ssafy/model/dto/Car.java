package com.ssafy.model.dto;

/**
 * dto (Data Transfer Object) = vo(Value Object) : 데이터를 표현하는 객체
 */
public class Car {
	private String num;
	private String model;
	private int price;

	public Car() {}

	public Car(String num, String model, int price) {
		super();
		this.num = num;
		this.model = model;
		this.price = price;
	}


	public String getNum() {
		return num;
	}

	public void setNum(String num) {
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Car [num=").append(num).append(", model=").append(model).append(", price=").append(price)
				.append("]");
		return builder.toString();
		
//		return new StringBuilder()append("Car [num=").append(num).append(", model=").append(model).append(", price=").append(price)
//		.append("]");
	}

}
