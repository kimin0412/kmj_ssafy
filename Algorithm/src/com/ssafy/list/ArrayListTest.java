package com.ssafy.list;

import java.util.ArrayList;

/**
 * List : 
 *   - 데이터를 순차적으로 유지 
 *   - 새로운 데이터를 추가할 수 있는 위치는 0~size()번째(맨마지막)까지 
 *   - 범위를 벗어나면 IndexOutOfBoundsException이 발생한다.
 * 
 * ArrayList : 
 *   - 배열로 List를 구현 
 *   - 중간 삽입이나 삭제가 많으면 데이터를 이동시키기 때문에 Overhead가 크다.
 * 
 */
public class ArrayListTest {
	public static void main(String[] args) {
		/*
		 * ArrayList는 기본 생성자로 생성하면 size가 0인 배열이 할당되고 데이터 추가 시 객체 낭비가 심하다 => 생성시 size를
		 * 지정하는 것이 좋다.
		 */
//		배열사이즈 변경할 수 있는 종류는 script종류 언어밖에 없다. js나 python 같은거

		ArrayList<String> list = new ArrayList<>(5);
//		add() : 맨 마지막에 데이터 추가
		list.add("hello");
		list.add("hello");
		list.add("world");

//		add(int idx, 저장할 데이터) : 지정한 index에 데이터가 추가된다.
//		list.add(5, "ssafy");   //에러가 난다.
		list.add(0, "ssafy");   //0번쩨 부터 밀린다.
		System.out.println(list);
		
//		get(int idx) : 지정한 index의 데이터를 추출
		System.out.println(list.get(0));
		System.out.println(list);
		
//		indexOf(Object o) : 데이터가 저장된 index를 list의 앞에서 부터 찾아서 리턴, 못찾은 경우 -1
//		lastIndexOf() : 데이터가 저장된 index를 list의 뒤에서 부터 찾아서 리턴, 못찾은 경우 -1
		System.out.println(list.indexOf("hello"));
		System.out.println(list.lastIndexOf(("hello")));
		
//		remove(int idx) : index번째의 데이터를 바로 삭제
//		remove(Object o) : 데이터 o를 찾아서 삭제
		System.out.println(list.remove(0));
		System.out.println(list.remove("hello"));
		System.out.println(list);
		
//		set(int idx, Object o) : idx번째에 데이터를 셋팅
		list.set(0, "kdg");
//		list.set(2, "ssafy");  //없는 index에 데이터를 set하면 IndexOutOfBoundsException 발생
		System.out.println(list);
		
	}
}
