package com.ssafy;

/**
 * Wrapper class
 * - 8가지 primitive type(byte, short, char, int, long, float, double, boolean)을 객체화
 * boolean 외에 것들은 서로 형변환 가능. boolean은 혼자만 형변환 안됨
 * 객체화  
 * 
 *
 */
public class WrapperTest {
	public static void main(String[] args) {
		//primitive => wrapper   생성자로 객체 생성
		Integer price = new Integer(5000);
		Double PI = new Double(3.14);
		
		//wrapper => primitive    xxxValue();
		int p = price.intValue();
		double pi = PI.doubleValue();
		
		//java5 부터 Auto box, unboxing을 제공
		Integer num = 100;  //Auto box
		int inum = num;     //Auto unboxing
		
//		parsexxx : 문자열로 된 데이터를 해당 포맷의 primitive 타입으로 변경
//					잘못된 포맷인 경우 NumberFormatException 발생
//		Integer.parseInt("3.14"); //정수로 변화 NumberFormatException 발생
		Integer.parseInt("3000"); //정수로 변화 NumberFormatException 발생
		
//		초기화 되지 않은 local 변수는 연산이나, 메서드 인자, 리턴으로 전달하면 컴파일 오류 발생
		String s;
//		System.out.println(s);
		
		Member member = null;
		System.out.println(member.getEmail());
	}
}
