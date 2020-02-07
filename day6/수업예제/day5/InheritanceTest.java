package com.ssafy;




public class InheritanceTest {
  public static void main(String[] args) {
     System.out.println("====부모객체생성=====");
	 Parent p = new Parent();
	 System.out.println("X="+ p.x);
	 p.hello();
	 //p.goodBye();
	 //에러발생: 부모레퍼런스 통해 절대 자식 호출 불가 !!
	 System.out.println("====자식객체생성=====");
	 
	 Child c = new Child();
	 System.out.println("Y="+c.y);
	 c.goodBye();
	 System.out.println("X="+c.x);
	 c.hello();
	 System.out.println("====(부모=자식)=====");
	 //Child c2 = new Parent();
	 Parent p2 = new Child();
	 p2.hello();
	 //p2.goodBye();//부모통해 자식호출 불가
	 p2.print();
	 

  }
}





