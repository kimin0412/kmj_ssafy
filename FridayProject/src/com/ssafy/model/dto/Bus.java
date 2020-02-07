package com.ssafy.model.dto;

public class Bus extends Car {
	private int seat;
	
	public Bus() {}

	public Bus(String num, String model, int price, int seat) {
		super(num, model, price);
		this.seat = seat;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Bus [seat=").append(seat).append("]");
		return builder.toString();
	}

}
