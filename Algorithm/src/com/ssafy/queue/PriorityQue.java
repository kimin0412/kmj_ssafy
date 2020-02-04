package com.ssafy.queue;

import java.util.PriorityQueue;

public class PriorityQue {

	public static void main(String[] args) {
//		PriorityQueue : String, Wrapper를 제외한 객체는 Comparable이 구현되지 않은 경우 error 발생
		PriorityQueue<Integer> queue = new PriorityQueue<>();
//		객체는 어떤 속성을 비교해야할지 알 수 없기 때문에 우리가 지정해주어야한다.
//		우선순위가 높은 것부터 출력
		queue.offer(1);
		queue.offer(5);
		queue.offer(3);
		System.out.println(queue);
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		
	}

}
