package com.ssafy;

class AA{
	int sum; //=0
	String name; //=null
//	Aa() {  //이름이 같이 않으므로 메서드가 되고 리턴 타입이 없기 때문에 오류가 난다.
//	하나의 클래스에는 반드시 하나 이상의 생성자가 존재해야한다.
	AA() {  //	이것은 기본생성자 이다.
		//보통 멤버변수에 대한 초기화 작업!!
		sum = 100;
		name = "아무개";
		System.out.println("기본 생성자");
	}
//	기본생성자가 없는 경우 -> 자동으로 생성된다.
//	기본생성자가 없고 오버로딩 생성자만 있을 경우 -> 생성자가 자동으로 만들어지지 않으므로 기본생성자가 없는 경우가 되어 오류가 난다. 
	
	AA(String str) { //오버로딩 생성자 : 몇개든지 만들 수 있다.
		System.out.println("오버로딩 생성자");
	}
	void hello() {  //메서드는 항상 클래스 안에 들어간다.
		System.out.println("안녕^^");
	}
}

public class ConstructorTest {

	public static void main(String[] args) {
		AA a = new AA();  //a는 실제 주소를 담고있는 주소를 지칭하는 것
//		A a = new A();
//		A a2;
//		a2 = a; -> 주소값이 들어감
//		<this> : 자기참조 연산자, 메서드 내에서 사용, 객체 생성자 내에서 다른 생성자를 호출 시 사용.
//		매개변수(지역변수)와 멤버변수(필드)를 구분하기 위해 멤버변수 앞에 this.을 붙여 사용.
		a.hello();
		System.out.println("SUM=" + a.sum);
		System.out.println("NAME=" + a.name);
	}

}
