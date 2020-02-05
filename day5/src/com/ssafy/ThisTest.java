package com.ssafy;

class B{  //총 멤버변수 4개
//	int y = 33;  //1개
	String str;
	
//	public B() { //Ctrl + Space + Enter -> 기본생성자
////		생성자 멤버
//	}
	
	B() {
//		System.out.println();
		this("SSAFY"); //this : 같은 클래스 내에 서로다른 생성자 간의 호출
//		this();는 무조건 첫번째 줄에 나와야한다. 무조건 무족권무족꿘
	}
	
	B(String str) {  //오버로딩 생성자
//		main()  ==>  |  B b = new B("자바");
//		str = str;  //매개변수랑 멤버변수 이름이 같으면 값이 바뀌지 않음
//		물론 매개변수를 String s 로 바꾸고 str = s; 로 해주면 상관없음
//		str에 지역성이 생겨서 받은값을 자기자신에 저장하기 때문에 안바뀜
		this.str = str;  //this를 붙인것은 멤버변수, 그냥 str은 지역변수
	}
	
	
	void hello() {  //2개
//		int z = 55;  //메서드 안에 있는 변수는 멤버변수로 취급하지 않는다.
		this.goodBye();  //그냥 goodBye(); 로도 호출 가능 : 같은 class 내에 있으므로
	}
	void goodBye() {  //3개
		System.out.println("STR="+str);  //this.str
	}
	void print() {  //4개
		
	}
}


public class ThisTest {

	public static void main(String[] args) {
//		B b = new B("자바");
		B b = new B();
		b.goodBye();
		
		
		
	}

}
