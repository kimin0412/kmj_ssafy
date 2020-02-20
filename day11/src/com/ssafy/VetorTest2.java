package com.ssafy;

import java.util.Vector;

class B{
	void hello() { System.out.println("B클래스 안녕~~!!");}
}

public class VetorTest2 {
	public static void main(String[] args) {
		Vector v = new Vector<>();
		v.add("안녕"); //인덱스 0 부여
		v.add(new B()); //인덱스 1부여
		
		//데이터 읽기(조회) ==> get(int index)
		//문제) 벡터 v에 저장된 B클래스의 hello() 메소드를 호출하시오.
		Object ob = v.get(1);
//		ob.hello(); //에러발생 ---> 왜? 부모 통해서 자식 호출 불가.
		B b = (B)ob;
		b.hello();
//		-----------------------------------------
		/**
		 * <> : 제네릭 타입 ---> 어떤 자료형을 사용할 지를 명시(명료성을 높임) : JDK5버전 부터.
		 * 
		 * 	<E> : element(요소)가 어떤 자료형을 사용할 지 명시.
		 * 	<K> : key가 어떤 자료형을 사용할 지 명시.
		 * 	<V> : value가 어떤 자료형을 사용할 지 명시.
		 * 	<T> : type에 어떤 자료형을 사용할 지 명시.
		 * 
		 */
		
		Vector<B> v2 = new Vector<>();  //JDK7 버전부터 생성자<> 빈괄호 지원
//		v2.add("홍길동"); //에러발생
		v2.add(new B());
//		B b2 = v2.get(0);
//		b2.hello();
		v2.get(0).hello();  //위의 두 코드 합쳐서 
//		단점 : 선언할때 길다.  장점 : 한번만 해주면 편하다.
		
		
	}
}
