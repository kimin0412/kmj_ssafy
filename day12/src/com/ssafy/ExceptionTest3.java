package com.ssafy;

class MyException extends Exception {// 사용자 정의 예외 클래스

	public MyException(String msg) {
		super(msg); // 부모 생성자가 갖는 기능을 실행
	}
}

public class ExceptionTest3 {
	public static void main(String[] args) {
//		MyException m = new MyException("사용자 정의 예외 메시지!");
//		throw m;
		boolean conditions = true;

		try {
			if (conditions) {
				throw new MyException("사용자 정의 예외 메시지!!");
			}
			System.out.println("정상실행~!!");
		} catch (MyException e) {
			e.printStackTrace();
		}
	}// return의 역할이기 때문에 if문 안에
}
