package com.ssafy.step06.queue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Q04_PriorityQueueTest {
	
	static class Student implements Comparable<Student>{
		int no, score;

		public Student(int no, int score) {
			super();
			this.no = no;
			this.score = score;
		}

		@Override
		public int compareTo(Student o) {
			return this.no - o.no;
		}

		@Override
		public String toString() {
			return "Student [no=" + no + ", score=" + score + "]";
		}
	}

	public static void main(String[] args) {
//		PriorityQueue<Student> queue = new PriorityQueue<Student>();
		PriorityQueue<Student> queue = new PriorityQueue<Student>(new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				return o2.score - o1.score;
			}
		});
		queue.offer(new Student(1, 100));
		queue.offer(new Student(10, 50));
		queue.offer(new Student(5, 10));

		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		
		
		
		
	}
}
