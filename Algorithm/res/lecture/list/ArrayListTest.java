package com.ssafy.list;

import java.util.ArrayList;

/**
 * List :
 *   - 데이타를 순차적으로 유지 
 *   - 새로운 데이타를 추가할 수 있는 위치는 0~size()번째까지  
 *	      범위를 벗어나면 IndexOutOfBoundsExceptiond이 발생한다.
 *
 * ArrayList 
 *   - 배열로 List를 구현 
 *   - 중간 삽입이나 삭제가 많으면 데이타를 이동시키기 때문에 Overhead가 크다 
 *   
 */
public class ArrayListTest {
	public static void main(String[] args) {
/*
 * 		ArrayList는 기본 생성자로 생성하면 size가 0이 배열이 할당되고 데이타 추가시 객체 낭비가 심하다. 
 * 		=> 생성시 size를 지정하는 것이 좋다. 
 */
		ArrayList<String> list = new ArrayList<>(5);
//		add()  : 맨 마지막에 데이타 추가 
		list.add("hello");
		list.add("hello");
		list.add("world");
		
//		add(int idx, 저장할 데이타) : 지정한 index에 데이타가 추가된다. 0~size 위치에 추가할 수 있다. 
//		list.add(5, "ssafy");
		list.add(0, "ssafy");
		System.out.println(list);
		
//		get(int idx) 	: 지장한 index의 데이타를 추출 
		System.out.println(list.get(0));
		System.out.println(list);
		
//		indexOf(Object o): 데이타가 저장된 index를  list의 앞에서 부터 찾아서 리턴, 못찾은 경우 -1 
//		lastIndexOf()    : 데이타가 저장된 index를  list의 뒤에서 부터 찾아서 리턴, 못찾은 경우 -1
		System.out.println(list.indexOf("hello"));
		System.out.println(list.lastIndexOf("hello"));
		
//		remove(int idx)	: index번째의 데이타를 바로 삭제
//		remove(Object o): 데이타 o를 찾아서 삭제 
		System.out.println(list.remove(0));
		System.out.println(list.remove("hello"));
		System.out.println(list);
		
//		set(int idx, Object o) : idx번째에 데이타를 셋팅  
		list.set(0,"kdg");
//		list.set(2,"ssafy");	  //없는 index에 데이타를 set하면 IndexOutOfBoundsException발생 
		System.out.println(list);
		

		
	}
}




















