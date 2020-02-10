package com.ssafy.queue;

import java.util.LinkedList;

public class QueueTest_API {
	public static void main(String[] args) {
		LinkedList<Integer> queue = new LinkedList<>();
		
		System.out.println(queue.size()); //원소 개수 
		System.out.println(queue.peek()); //원소를 제거하지 않고 추출만 
//		offer  :원소를 맨 끝에 추가(enQueue) 
		queue.offer(1);					  
		queue.offer(2);					  //원소를 맨 끝에 추가 
		queue.offer(3);					  //원소를 맨 끝에 추가 
//		contains(o)  : 인자에 해당하는 객체가 저장되어 있으면 true, 없으면  false
		System.out.println(queue.contains(3));
		System.out.println(queue);
		System.out.println(queue.peek()); //원소를 제거하지 않고 추출만 
		System.out.println(queue.peek()); //원소를 제거하지 않고 추출만
		
//		poll   : 맨 앞에 있는 데이타를 삭제 하면서 추출 (deQueue) 
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		
	}
}





