package com.ssafy.method;

public class stringTest3 {
	public static void main(String[] args) {
//		편집이 많은 문자열은 StringBuilder를 사용하자. String의 편집을 남용하면 안되기 때문에 String Builder를 사용한다.
		 StringBuilder sb = new StringBuilder("Hello");
		 sb.append("aaa");  //문자열 추가
		 System.out.println(sb);
		 System.out.println(sb.charAt(1));
		 System.out.println(sb.length());
		 sb.insert(0, "");  //원하는 위치에 삽입(append랑 다름)
		 sb.setLength(3);  //문자열 길이를 재설정 => 설정한 길이대로 잘림
		 System.out.println(sb);
		 sb.reverse();
		 System.out.println(sb);
		 
		 String s = sb.toString();  //toString은 모든 객체를 String으로 만들어줌. 다 쓸수 있음.
		 System.out.println(s);
//		 String에 덧셈(편집)을 하면 내부적으로 StringBuilder로 바뀌어서 편집됨
	}
}