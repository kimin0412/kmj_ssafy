package com.ssafy;

public class MemberTest {
   public static void main(String[] args) {
	  //데이터: '홍길동'  13   'gildong@naver.com'
	  //데이터 설정(주기)
	  Member m = new Member();
//	     m.name="홍길동";
//	     m.age=13;
//	     m.email="gildong@naver.com";
	  m.setName("나길동");   
	  m.setAge(13);   
	  m.setEmail("gildong@naver.com");   
	  
	  
//	  String temp= m.name;   
	  //데이터 조회(얻기)
//	  System.out.println("이름:"+m.name);   
//	  System.out.println("나이:"+m.age);   
//	  System.out.println("이메일:"+m.email);
	  System.out.println("이름:"+
                   m.getName());
	  
	  Member m2 = new Member("길라임", 15, 
			                  "lime@daum.net");
	  System.out.println("이름2: "+ m2.getName());
      System.out.println("==============");
      //Member m = new Member();
      //to~(): 변환 메소드 ,   toString(): 문자열 변환 메소드
      //toString(): 객체의 상태(속성값?)를 표현하는 메소드
      System.out.println(m.toString());
      System.out.println(m);
      System.out.println("---------------");
      System.out.println(m2.toString());
      System.out.println("m2==>"+m2);
      System.out.println("---------------");
      m2.setName("차라임");
      System.out.println("m2==>"+m2);
   }//main
}//MemberTest






