package com.ssafy.ws6;

public class Magazine extends Book{
// isbn, title, author, publisher, year, month, price, desc
// 35535    | Java World  | 편집부 | java.com   | 7000    | 첫걸음 | 2018.2
	private int year;
	private int month;
	
	public Magazine() {
	}

	public Magazine(String isbn, String title, String author, String publisher, int price, String desc, int year,
			int month) {
		super(isbn, title, author, publisher, price, desc);
		this.year = year;
		this.month = month;
	}
	
// 35535    | Java World  | 편집부 | java.com   | 7000    | 첫걸음 | 2018.2
	@Override
	public String toString() {
		return super.toString() + "\t|"+ year + "." + month ;
	}
	
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}
	
	
	
	
	
}
