package com.ssafy;

class B{
  String str;
  
  B() {
	this("SSAFY");//같은 클래스내에 다른 생성자 호출!! 
	System.out.println(); 
  } 
	  
  B(String str){   //main() ==>  B b = new B("자바");
	this.str=str;
  }



void hello() {
//	 this.goodBye();
	 goodBye();
  }
  void goodBye() {
	 System.out.println("STR="+ str);//this.str); 
  }
}

public class ThisTest {
  public static void main(String[] args) {
//	  B b = new B();
	  B b = new B("자바");
	  b.goodBye();
  }
}






