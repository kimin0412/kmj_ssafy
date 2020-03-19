package com.ssafy.step07.linkedlist;

public class L01_LinkedListTest {
	
	public static void main(String[] args) {
		SimpleLinkedList list = new SimpleLinkedList();
		list.addFirstNode("김태희");
		list.printList();
		list.addFirstNode("이동욱");
		list.printList();
		list.addFirstNode("이지아");
		list.printList();
		
		System.out.println(list.getNode("김태희"));
		System.out.println(list.getNode("이동욱"));
	}

}
