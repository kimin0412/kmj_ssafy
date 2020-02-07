package com.ssafy;

public class Parent {
   int x=300;
   void hello() {
	  System.out.println("안녕~!!");
   }
   void hello(String name) {//오버로딩 메소드
	  System.out.println("안녕,"+ name+"~!!");
   }
   void print() {
	  System.out.println("부모 프린트~!!"); 
   }
}
