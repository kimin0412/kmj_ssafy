package com.ssafy.queue;

import java.util.PriorityQueue;

public class PriorityQueueTest {
	public static void main(String[] args) {
//		PriorityQueue : String, Wrapper를 제외한 객체는  Comparable이 구현되지 않은 경우 error 발생
//		우선 순위가 높은 데이타 부터 추출 
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		queue.offer(1);
		queue.offer(5);
		queue.offer(3);
		System.out.println(queue);
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
	}
}




