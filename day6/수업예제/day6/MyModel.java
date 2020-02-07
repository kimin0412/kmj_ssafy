package com.ssafy;

class Parent{
   void hello(String name) {}	
}
class Sub1 extends Parent{
	void hello(String name) {System.out.println("봉쥬르,"+name);}
}
class Sub2 extends Parent{
	void hello(String name) {System.out.println("신짜오,"+name);}
}
//---------------------------------------------------------------
class Model{
	void greeting(Parent p,String name) {
		p.hello(name);
	}
}
//---------------------------------------------------------------
public class MyModel {
	public static void main(String[] args) {
		Sub1 s1 = new Sub1();//자식
		Sub2 s2 = new Sub2();
		Model m = new Model();
        m.greeting(s2, "너길동");		
        System.out.println("=================");
        Parent p = new Parent();//부모
        
        p=s1;//부모=자식
        
        Parent p2 = new Parent();
        //s2=p2;//자식=부모  ==> 컴파일 에러!!
        s2=(Sub2)p2;//자식=(자식)부모
        
        s2.hello("우리길동");
	}
  
}






