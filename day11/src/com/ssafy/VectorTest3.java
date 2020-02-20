package com.ssafy;

import java.util.Vector;

public class VectorTest3 {

	public static void main(String[] args) {
		//★Vector에 데이터 추가, 조회, 수정, 삭제 하기!!!
		Vector<String> v = new Vector<>();
		
		//데이터 추가
		v.add("자바"); //인덱스 0  이렇게 하면 안들어감
		v.add("SQL"); //인덱스  1
		v.add("HTML"); //인덱스  2
		v.add("JavaScript"); //인덱스  3
		v.add("JSP"); //인덱스  4
		v.add("자바"); //인덱스  5
//		v.add(new String("자바"));
		
		//데이터 삭제
//		v.remove(int index);
//		v.remove(Object o);
//		첫번째 데이터를 삭제하시오.
//		v.remove("자바");
		v.remove(0);
		
//		데이터 수정
		
		
		//전체 데이터 조회
		for (int i = 0; i < v.size(); i++) {
			System.out.println(i + " : " + v.get(i));
		}
		
		
//		String s1 = "java";
//		String s2 = "java";
//		String s3 = new String("java");
//		String s4 = new String("java");
//		
//		System.out.println(s1==s2);
//		System.out.println(s3==s4);
//		System.out.println(s3.equals(s4));
//		System.out.println(s2==s4);
//		System.out.println(s2==s4);
//		s1==s2 : true
//		s3==s4 : false
//		s3.equals(s4) : true
//		s2==s4 : false
//		s2==s4 : false
		
	}

}
