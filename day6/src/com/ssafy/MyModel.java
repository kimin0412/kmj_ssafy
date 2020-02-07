package com.ssafy;

class Parent {
	void hello(String name) {
//		System.out.println("Parent!!!!");
	}
}

class Sub1 extends Parent {
	void hello(String name) {
		System.out.println("봉쥬르, " + name);
	}
}

class Sub2 extends Parent {
	void hello(String name) {
		System.out.println("신짜오, " + name);
	}
}

//--------------------------------------------------------------------

class Model {
	void greeting(Parent p, String name) {
		p.hello(name);
	}
}

//--------------------------------------------------------------------

public class MyModel {
	public static void main(String[] args) {
		Model m = new Model();
		Sub1 s1 = new Sub1();
		Sub2 s2 = new Sub2();
		m.greeting(s1, "너길동");  //오버라이딩
		m.greeting(s2, "너길동");  //오버라이딩
		System.out.println("=============");
		Parent p = new Parent(); //부모
		
		p = s1;  //부모=자식
		
		Parent p2 = new Parent();  //=>메모리에 Parent와 Object이 생기는데 Sub에 관한 정보가 없어서 오류가 난다.
		//s2=p; //자식=부모  ==> 컴파일 에러!
		s2 = (Sub2)p2;  //자식=(자식)부모
		
//		NumberFormat Exception과 NullPointer Exception 이 오류 두개가 잘 난다.
		
		
		s2.hello("우리길동");
		
		
	}
		
		
		

}
