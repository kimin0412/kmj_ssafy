package com.ssafy;

import java.util.ArrayList;
import java.util.LinkedList;

public class ListTest {
  public static void main(String[] args) {
	   //ArrayList와 Vector는 사용문법이 같다!!
	   // ---> 차이점: ArrayList가 처리 속도가 빠르다 
	   //       (이유: Vector에는 동기화 코드가 추가되어있으므로)
	  
	  
	  /*
	  ArrayList ==> 데이터 1개 저장 : 한개의 index필요	   
	               만약 데이터의 수가 많고(100000) 첫번째 데이터(인덱스:0)를 삭제할때
	         ==> 뒤의 99999 데이터는 인덱스를 다시 지정해야함!!        
	                
	                
	  LinkedList ==> 데이터 1개 저장: 한개의 index, 앞의 데이터 주소, 뒤의 데이터 주소 저장 필요
	              만약 데이터의 수가 많고(100000) 첫번째 데이터(인덱스:0)를 삭제할때
	        
	         201호  202호   203호
	       ["길동","라임"(앞주소:201, 뒤주소:203호),"주원",.........]
	              -----
	                         삭제!!
            -----                              -----
            뒤주소(202) --> (203호)                   앞주소(202) ---> (201호)
	   */	  
	  //ArrayList와  LinkedList 속도 테스트
	  ArrayList<Person>  list10 = new ArrayList<Person>();
	  LinkedList<Person>  list20 = new LinkedList<Person>();
	  
	  //첫번째: 순차적인 입력!! 데이터를 뒤로 추가
	  
	  long start = System.currentTimeMillis();
	  for(int i=0; i<1000000; i++) {//반복횟수
		  list10.add(new Person(1,"홍길동",13,"학생"));
	  }
	  long end = System.currentTimeMillis();
	  System.out.println("ArrayList데이터입력시간(순차):"+ (end-start));
	  //---------------------------------------------------------------
	  start = System.currentTimeMillis();
	  for(int i=0; i<1000000; i++) {//반복횟수
		  list20.add(new Person(1,"홍길동",13,"학생"));
	  }
	  end = System.currentTimeMillis();
	  System.out.println("LinkedList데이터입력시간(순차):"+ (end-start));
	  //---------------------------------------------------------------
	  System.out.println("==========================");
	  //두번째:중간 입력(ArrayList는 인덱스에 대한 재배열)!!
	  // List[]        0,"길동"입력
	  // List["길동"]   0,"주원"입력
	  // List["주원","길동"]   0,"라임"입력
	  //        0     1
	  // List["라임","주원","길동"]
	  //               1    2
	  ArrayList<Person>  list30 = new ArrayList<Person>();
	  LinkedList<Person>  list40 = new LinkedList<Person>();
	  
	  start = System.currentTimeMillis();
	  for(int i=0; i<1000000; i++) {//반복횟수
		  //list30.add(int index, Object 데이터);
		  list30.add(0, new Person(1,"홍길동",13,"학생"));
	  }
	  end = System.currentTimeMillis();
	  System.out.println("ArrayList데이터입력시간(중간입력):"+ (end-start));
	  
	  start = System.currentTimeMillis();
	  for(int i=0; i<1000000; i++) {//반복횟수		  
		  list40.add(0, new Person(1,"홍길동",13,"학생"));
	  }
	  end = System.currentTimeMillis();
	  System.out.println("LinkedList데이터입력시간(중간입력):"+ (end-start));
	   
	  //결론) 만약, 데이터의 수가 적고  순차적인 저장을 하며  조회업무를 많이한다  ==> ArrayList
	  //     만약, 데이터의 수가 많고  순차적이지 않은 저장을 하며  삭제업무를 많이한다 ==> LinkedList	  
  }
}
