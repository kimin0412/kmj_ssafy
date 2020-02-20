package com.ssafy;

//둥지 클래스
class NestingClass{
	int i = 11;
	void hello() {
		System.out.println("안녕~!!");
//		print(); //담 너머는 안보영 -> 오류남
		NestedClass nested = new NestedClass();
		nested.print(); //일반적으로 사용.
		//내부클래스는 보통 외부클래스에서 생성자로 생성해서 호출한다.
	}
//-----------------------------------------------
//뻐꾸기 클래스
	class NestedClass{  //뻐꾸기
		int j = 22;
		void print() {
			System.out.println("프린트~!!");
		}
		
		//내부클래스 --> 외부클래스 자원(멤버) 사용!!
		void callTest() {
			hello();
			System.out.println("i = " + i);
		}
		
	}//내부 클래스
	
}//외부 클래스


public class NestedClassTest {
	public void good() {}
	public static void main(String[] args) {
//		good(); //호출 안됨 다른 멤버로 취급. static이 아니므로...
		NestingClass nesting = new NestingClass();
		nesting.hello(); //외부클래스 메소드

		//내부클래스의 print 메소드를 직접 호출 : 잘 사용하지 X
//		==> 객체생성 : 외부클래스명.내부클래스명 참조변수명 = new 외부생성자().new 내부생성자();
		System.out.println("=========================");
		NestingClass.NestedClass nested = new NestingClass().new NestedClass();
		nested.print();
		
		
	}

}
