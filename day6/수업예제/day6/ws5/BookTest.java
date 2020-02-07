package com.ssafy.ws5;

public class BookTest {
  public static void main(String[] args) {
	 /* 
	  *********************** 도서 목록 ************************** 
	  21424    | Java Pro    | 김하나 | Jaen.kr    | 15000   | Java 기본 문법 
	  35355    | 분석설계 | 소나무 | Jaen.kr    | 30000   | SW 모델링 
	  35535    | Java World  | 편집부 | java.com   | 7000    | 첫걸음 | 2018.2
	  */
     Book b1 = new Book("21424", "Java Pro", "김하나", "Jaen.kr", 15000, "Java 기본 문법");
     Book b2 = new Book("35355", "분석설계", "소나무", "Jaen.kr", 30000, "SW 모델링");
     //new Magazine(isbn, title, author, publisher, price, desc, year, month)
     Magazine m1 = new Magazine("35535", "Java World", "편집부", "java.com", 7000, "첫걸음",2018,2);
     
     System.out.println("*********************** 도서 목록 ************************** ");
     System.out.println(b1.toString());
     System.out.println(b2.toString());
     System.out.println(m1.toString());
  }
}
