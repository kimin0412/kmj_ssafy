package com.ssafy;
/**
 * Singleton pattern
 * 클래스로 부터 생성되는 객체는 단 하나를 보장한다. (여러개 쓰면 큰일남)
 * 1. 생성자는 private으로 선언한다. (아무나 객체생성 못하도록, 안에서 딱 한번만 생성되도록
 * 2. 겍체를 전달하는 static method를 선언
 * 		=> 헤당 타입의 객체를 static한 속성으로 선언
 * 
 */
public class MySingleton {
	private static MySingleton instance;
	
	private MySingleton() {}
	
	public static MySingleton getInstance() {
		if (instance == null) {
			instance = new MySingleton();
		}
		return instance;
	}

	public void test() {
		System.out.println(this.hashCode() + "가 수행되고 있습니다.");
	}

}
