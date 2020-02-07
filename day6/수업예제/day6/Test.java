package com.ssafy;

class AA{
   void hello() {System.out.println("더블A~!!");}	
}
class My2{
   AA  a;//AA a = null;
  
   public My2() {
	  //a = new AA();
   }
  
   void callTest() {
	   a.hello();
   }
}
public class Test {
   public static void main(String[] args) {
	  My2 m2 = new My2();
	  m2.callTest();
	   
	  int su = Integer.parseInt("123");
	  System.out.println(su);
	  System.out.println(su+100);
	  
//	  int su2 = Integer.parseInt("123a"); //RuntimeError
//	  System.out.println("su2="+su2);
	  
	  //int su3 = "123"; //CompileError
	  
	  
   }
}
