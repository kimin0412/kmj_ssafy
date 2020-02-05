package com.ssafy.method;

public class stringTest {
//	한줄복사 : Ctrl + Alt + 아래방향키
	public static void main(String[] args) {
		String s = new String("Hello");  //java.lang에 있는 건데 import하지 않아도 자바 컴파일러에 들어있으므로 괜찮다.
		String s1 = "Hello";  //원래 new로 객체생성한 후 사용해야하는데 너무 자주쓰이니까 그냥 써도 사용가능도록 해놨다.
		
		s1 = s1 + "aaaa";  //string만 '+'연산이 가능하다
//		class는 mathod와 변수를 가지고 있다.
		System.out.println(s1.length());
		System.out.println(s1.charAt(0));
		System.out.println(s1.concat("bbb"));  //덧셈(문자열 더하기) '+'
		System.out.println(s1.contains("lo"));   //포함?
		System.out.println(s1);
		System.out.println(s1.endsWith("a"));   //concat은 원래 문자열을 수정하지 않기 때문에 true로 나온다(bbb반영 안됨)
		System.out.println(s1.indexOf("o"));   //o의 위치 출력
		System.out.println(s1.replace("a", "A"));
		System.out.println(s1);
		System.out.println(s1.substring(2,5));  //2~4번째 문자 가져옴 *주의*두번째 인덱스는 포함 안됨->그 인덱스 전까지
		System.out.println(s1.toLowerCase());  //모두 소문자
		System.out.println(s1.toUpperCase());  //모두 대문자
		System.out.println(s1.trim());  //양쪽의 여백을 제거 -> 키보드 입력은 무조건 trim 거칠것.
		
		String s2 = "I am a boy";
		String[] msg = s2.split(" ");
		for (String ss : msg) {
			System.out.println(ss);
		}
		String[] masg2 = s1.split("");  //공백을 안주면 한글자씩 잘린다. 나중에 입력받을때 이런식으로 하면 편함
		for (String ss : masg2) {
			System.out.println(ss);
		}
	}
}
