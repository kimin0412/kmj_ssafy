package com.ssafy;

public class MemberTest2 {

	public static void main(String[] args) {
		//데이터 : '홍길동'  13  'gildong@naver.com'
		//데이터 설정(주기)
//		Member m = new Member();
//			m.name = "홍길동";
//			m.age = 13;
//			m.email = "gildong@naver.com";
		
		
//		String temp = m.name;
		//데이터 조회(얻기)
		
	
//		System.out.println("이름 : "+m.name);
//		System.out.println("나이 : "+m.age);
//		System.out.println("이메일 : "+m.email);
		
		Member m2 = new Member("길라임", 15, "lime@daum.net");
		
		System.out.println("이름2 : "+ m2.getName());
		
		
	}

}
