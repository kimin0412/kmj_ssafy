package com.ssafy.ws6;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BookTest {
  public static void main(String[] args) throws Exception{
	 /* 
	  *********************** 도서 목록 ************************** 
	  21424    | Java Pro    | 김하나 | Jaen.kr    | 15000   | Java 기본 문법 
	  35355    | 분석설계 | 소나무 | Jaen.kr    | 30000   | SW 모델링 
	  35535    | Java World  | 편집부 | java.com   | 7000    | 첫걸음 | 2018.2
	  */
	  
	 //데이터 정의 
     Book b1 = new Book("21424", "Java Pro", "김하나", "Jaen.kr", 15000, "Java 기본 문법");
     Book b2 = new Book("35355", "분석설계", "소나무", "Jaen.kr", 30000, "SW 모델링");
     Magazine m1 = new Magazine("35535", "Java World", "편집부", "java.com", 7000, "첫걸음",2018,2);
     
     //1. 데이터 입력 기능   ===> Book과 Magazine을 하나의 배열에 저장(입력)
     Book []books = new Book[3];
        books[0]=b1;
        books[1]=b2;
        books[2]=m1; //Magazine이 Book클래스의 자식이기 때문에 저장 가능
     
     //2. 데이터 전체 검색 기능 
     System.out.println("*********************** 도서 목록 ************************** ");
     for (int i = 0; i < books.length; i++) {
	    System.out.println(books[i]);	
	 }   
     
     //3. Isbn 으로 정보를 검색하는 기능
     BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
     System.out.print("\n검색할 Isbn입력: ");
     String isbn = in.readLine();
     
     System.out.println("\n******************** 도서 목록(isbn기준) ************************ ");
     for (int i = 0; i < books.length; i++) {
    	if(isbn.equals(books[i].getIsbn())){ 
 	      System.out.println(books[i]);	
    	}
 	 }
     
     //4. Title로 정보를 검색하는 기능( 파라메터로 주어진 제목을 포함하는 모든 정보) 
     System.out.print("\n검색할 Title입력: ");
     String title = in.readLine();
     
     System.out.println("\n******************** 도서 목록(isbn기준) ************************ ");
     for (int i = 0; i < books.length; i++) {
    	if(books[i].getTitle().contains(title)){ 
 	      System.out.println(books[i]);	
    	}
 	 }
     
     //5. Book만 검색하는 기능
     System.out.println("\n******************** 도서 목록(Book만 검색) ************************ ");
     for (int i = 0; i < books.length; i++) {
    	if(! (books[i] instanceof Magazine) ){ 
 	      System.out.println(books[i]);	
    	}
 	 }
     
     //6. Magazine만 검색하는 기능 
     System.out.println("\n******************** 도서 목록(Magazine만 검색) ************************ ");
     for (int i = 0; i < books.length; i++) {
    	if(books[i] instanceof Magazine){ 
 	      System.out.println(books[i]);	
    	}
 	 }
     
     
     //8. 출판사로 검색하는 기능 
     System.out.print("\n검색할 출판사 입력: ");
     String publisher = in.readLine();
     System.out.println("\n******************** 도서 목록(출판사기준) ************************ ");
     for (int i = 0; i < books.length; i++) {
    	if(publisher.equals(books[i].getPublisher())){ 
 	      System.out.println(books[i]);	
    	}
 	 }
     
     
     //9. 가격으로 검색 기능 (파라메터로 주어진 가격보다 낮은 도서 정보 검색) 
     System.out.print("\n검색할 가격 입력: ");
     int price = Integer.parseInt(in.readLine());
     System.out.println("\n******************** 도서 목록(가격기준) ************************ ");
     for (int i = 0; i < books.length; i++) {
    	if(price >= books[i].getPrice()){ 
 	      System.out.println(books[i]);	
    	}
 	 }
     
     //10. 저장된 모든 도서의 금액 합계를 구하는 기능
     System.out.println("\n******************** 모든 도서의 금액 합계 ************************ ");
     int sum=0;
     for (int i = 0; i < books.length; i++) {
    	sum += books[i].getPrice();
 	 }
     System.out.println("\t"+sum+"원");
     
     //11. 저장된 모든 도서의 금액 평균을 구하는 기능
     System.out.println("\n******************** 모든 도서의 금액 평균 ************************ ");
     double avg= sum/ (books.length*1.0) ;
     
     System.out.println("\t"+avg+"원");
     System.out.println("\t"+Math.round(avg*100)/100.0+"원");
     System.out.printf("\t%.2f원", avg);
     System.out.println("\n\t"+String.format("%.2f원", avg));
  }
}





