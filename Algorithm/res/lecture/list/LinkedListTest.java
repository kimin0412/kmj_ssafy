package com.ssafy.list;

import java.util.LinkedList;

/**
 * List :
 *   - 데이타를 순차적으로 유지 
 *   - 새로운 데이타를 추가할 수 있는 위치는 0~size()번째까지  
 *	      범위를 벗어나면 IndexOutOfBoundsExceptiond이 발생한다.
 *
 * LinkedList 
 *   - Double Link로 구성 
 *   - ArrayList보다 n*8byte를 더 사용한다. 
 *   - 중간 삽입, 삭제가 많은 경우 Link 변경을 통해 처리하므로 ArrayList보다 성능이 좋다. 
 *   
 */
public class LinkedListTest {
	public static void main(String[] args) {
//		ArrayList와 다르게 초기 size를 지정할 수 없다. 
		LinkedList<String> list = new LinkedList<>();
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




















