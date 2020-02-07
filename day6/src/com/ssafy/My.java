package com.ssafy;

class You{
    static public void dinner() {}
}

public class My {
    public int sum;
    final int MAX=100;//고정값 명시
    public void hello() { }    
    public void goodBye() {//같은 클래스 메소드 호출
    	 hello();}
    public static void happySsafy(){}
    public static void main(String[] args) {
    	//같은 클래스 static 아닌 메소드 호출
		My m = new My();
		m.hello();
		//m.max++;
		System.out.println("최대값:"+ m.MAX);
		
		//같은 클래스 static멤버 사이의 호출
		happySsafy();
		
		//다른 클래스 static멤버 사이의 호출
		You.dinner();
	}
}




