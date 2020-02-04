package com.ssafy.array;
/**
 * 
 * @author multicampus
 * 기본타입(Primitive type)
 * - 자바에서 기본적으로 제공하는 데이터타입으로 선언된 변수에 실제 값이 저장된다.
 *     정수 - byte   short  int    long
 *          1byte  2byte  4byte  8byte
 *     실수     float   double
 *          4byte   8byte
 *     문자     char
 *          2byte-unicode 사용
 *     논리   boolean
 *     boolean을 제외한 나머지는 자동형변환 가능
 *     자동형변환은 
 *     byte => short,char => int => long => float => double 가능 
 *     반대로 갈때는 형변환해줘야함
 * 
 * 객체 - 참조형타입(Reference type)
 * - 사용자 정의 타입으로 변수에는 hashcode가 저장되고 
 * 생성된 객체는 heap에 생성되어 hashcode를 통해 객체를 참조한다.
 *  
 */
public class DataTypeTest {
	public static void main(String[] args) {
		//변수선언
		//데이터타입 변수명; or 데이터타입 변수명=값;
		int a = 10; //primitive type
		Object o = new Object(); //reference type
		
		System.out.println(a);
		System.out.println(o); //해시코드 같이 출력
	}

}
