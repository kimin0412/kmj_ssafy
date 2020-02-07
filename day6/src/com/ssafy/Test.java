package com.ssafy;

class AA{
	void hello() {System.out.println("더블 A~!!");}
}
class My3{
	AA a;  //AA a = null; => 준비상태가 아니다. 메모리 할당이 안됐다.
	
	public My3() {
		a = new AA();
	}
	void callTest() {
		a.hello();
	}
}

public class Test {

	public static void main(String[] args) {
		My3 m3 = new My3();
		m3.callTest(); //=> 메모리 할당이 안되서 NullPointer Exception 오류가 난다.
		
		int su = Integer.parseInt("123");
		System.out.println(su);
		System.out.println(su+100);
		
//		int su2 = Integer.parseInt("123a");
//		System.out.println(su);
	}

}
