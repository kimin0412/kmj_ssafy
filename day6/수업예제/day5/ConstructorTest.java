package com.ssafy;

class AA{
	int sum;//=0
	String name;//=null
	
	AA() {//기본생성자
	  //보통 멤버변수에 대한 초기화 작업!!
	  sum=100;
	  name="아무개";
	  
	  System.out.println("기본생성자");
	}
	AA(String str){//오버로딩 생성자
	  System.out.println("오버로딩생성자");	
	}
	void hello() {
		System.out.println("안녕^^");
	}
}

public class ConstructorTest {
   public static void main(String[] args) {
	  AA a = new AA();
	  //AA a = new AA("문자열");
	   a.hello();
	   System.out.println("SUM="+ a.sum);
	   System.out.println("name="+ a.name);
   }
}


