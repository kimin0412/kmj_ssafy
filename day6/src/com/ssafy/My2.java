package com.ssafy;

class You2{
	
}

public class My2 {
    public int sum;
    final int max = 100;
    public void hello() {
    	//동적 멤버
    }
    public void goodBye() { //같은 클래스 메소드 호출
    	hello();
    }
    
    public static void happySsafy(){
//    같은 클래스 static 아닌 메소드 출력	
    }
    
    public static void main(String[] args) {
//		
    	My2 m = new My2(); //static멤버
    	m.hello();
    	happySsafy();  //static끼리는 멤버이기 때문에 호출가능
    	
    }
    
}
