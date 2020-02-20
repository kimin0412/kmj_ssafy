package com.ssafy;

import java.util.Enumeration;
import java.util.Vector;

public class VectorTest {
   public static void main(String[] args) {
		  //Vector(int initialCapacity, int capacityIncrement)
		  //initialCapacity:방의 크기, capacityIncrement: 방크기의 증가치
	   
     Vector v = new Vector(5,3);//벡터: 데이터(element요소)를 담는 바구니

	 System.out.println("벡터의 용량(방크기): "+ v.capacity());//5
	 System.out.println("벡터의 요소(입력된 데이터)갯수: "+ v.size());//0
	 
	  //벡터는 객체의 참조(a, new A())를 담는 배열
	  Integer su = new Integer(1);
	  int su2=2;
	  
//	  Integer su3=3;
//	  int su4= new Integer(4);
	  
	 v.addElement(su);
	 v.addElement(su2);
     
	 for(int i=3; i<10; i++) {
		 v.add(i);
	 }
	 
	 System.out.println("벡터의 용량(방크기): "+ v.capacity());//5
	 System.out.println("벡터의 요소(입력된 데이터)갯수: "+ v.size());//0
	 
	 v.add(true);
	 v.add(3.14);
	 v.add("자바");
	 System.out.println("벡터의 용량(방크기): "+ v.capacity());//5
	 System.out.println("벡터의 요소(입력된 데이터)갯수: "+ v.size());//0
	 
	 if(v.contains(3.14)) {//요소 포함시 true리턴
		 System.out.println("3.14를 포함");
	 }
	 
	 //벡터의 모든 요소 출력
	 Enumeration enu = v.elements();
	 //--> 열거형인터페이스 enu = [1,2,3,4,.....,"자바"];
	 System.out.println("=================");
	 while(enu.hasMoreElements()) {
		 System.out.println(enu.nextElement());
	 }
	 System.out.println("=================");
     System.out.println("맨앞의 데이터: "+ v.firstElement());	 
     System.out.println("맨뒤의 데이터: "+ v.lastElement());	 
	 
   }//main
}








