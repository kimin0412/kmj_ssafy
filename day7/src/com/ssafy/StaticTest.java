package com.ssafy;
/**
 * static
 *  - 정적인 특성을 부여하는 modifier
 *  - 클래스가 로딩될 때 한번 수행 됨
 *  - 객체 생성 없이 클래스명으로 접근이 가능
 *    className.속성명  className.메서드명(~)
 *    
 *  - 속성
 *  	클래스가 로딩될 때 한번 메모리(mathod area)에 할당됨.
 *  	모든 객체가 공유하는 공유 변수가 됨.
 *  
 *  - 메서드
 *  	클래스가 로딩될 때 메서드 binding이 된다.
 * 		객체 생성 없이 메서드 호출할 때 사용
 * 		주의점 : static이 아닌 속성이나 메서드에 접근 불가
 * 		
 * 	- static block
 * 		클래스 로딩 될 때 한번 수행됨.
 * 		- static 속성을 초기화
 * 		- 단 한번 수행되는 코드를 작성
 * 		형식]
 * 		static {
 * 			//단 한번 수행될 코드
 * 		}
 *  - instance block
 *  	- 객체 생성할 때마다 생성자 보다 먼저 수행됨.
 *  	- 객체 생성 시 공통으로 사용되는 코드 작성  
 * 
 */
class Counter{
	static int scnt;
	int icnt;
	public Counter() {
		System.out.println("Counter() .........");
		scnt++;
		icnt++;
	}
	
	static {
		System.out.println("static block .........");		
	}
	{		
//		System.out.println("static block .........");		
		System.out.println("instance block .........");		
	}
		
	public static void sprint() {
//		static 메서드에서 static이 아닌 속성이나 메서드에 접근 불가
//		System.out.printf("scnt : %d, icnt : %d\n", scnt, icnt);
		System.out.printf("scnt : %d\n", scnt);
		
	}
	public void print() {
		System.out.printf("scnt : %d, icnt : %d\n", scnt, icnt);
	}
}
public class StaticTest {  //class 앞에 private, protected, static 안됨. 안된다고. 안돼 그냥 안돼 하지마.

	public static void main(String[] args) {
//		자바는 동적이다 : 클래스 로딩을 동적으로 한다.
		System.out.println("Counter.scnt : " + Counter.scnt);
		Counter c1 = new Counter();
		c1.print();
		Counter c2 = new Counter();
		c2.print();
		Counter c3 = new Counter();
		c3.print();
		
		c1.print();
		c2.print();
		c3.print();
		
	}

}
