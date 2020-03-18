package com.ssafy.step06.priorityqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @author taehee kim
 */
public class Solution1812 {

	static class Rectangle implements Comparable<Rectangle>{
		
		int min,max;
		
		public Rectangle(int width,int height) {
			if(width<height) {
				min = width;
				max = height;
			}else {
				min = height;
				max = width;
			}
		}
		@Override
		public int compareTo(Rectangle o) {
			return o.min - this.min;
		}
	}

	static int N,M, size[],cnt;
	static PriorityQueue<Rectangle> queue;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(in.readLine());
		
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			size = new int[N];
			cnt = 0;
			
			st = new StringTokenizer(in.readLine(), " ");
			for (int i = 0; i < N; i++) {
				size[i] = Integer.parseInt(st.nextToken());
			} // 만들고자하는 정사각형의 크기(2^k) 입력 (k)
			
			cut();
			sb.append("#"+tc+" "+cnt+"\n");
		}
		System.out.println(sb.toString());
	}
	private static void cut() {
		// 가장 큰 크기의 정사각형부터 만들기
		Arrays.sort(size);
		queue = new PriorityQueue<Rectangle>();
		queue.offer(new Rectangle(M, M));
		++cnt;
		
		for (int i = N-1; i >=0; i--) {
			go(1<<size[i]);  //1<<2
		}
	}
	private static void go(int size) {
		// queue에서 poll() : min값이 최대인 직사각형이 뽑아집
		// 직사각형의 최소변의 길이가 size보다 같거나 크면 : 원하는 크기의 정사각형을 만들 수 있음
		Rectangle r = queue.poll();
		if(r.min>=size) {
			queue.offer(new Rectangle(r.min-size, size));
			queue.offer(new Rectangle(r.min, r.max-size));
		}else {   // 아니면 : 원하는 크기의 정사각형을 만들 수 없음
			queue.offer(r);
			queue.offer(new Rectangle(M-size, size));
			queue.offer(new Rectangle(M, M-size));
			++cnt;
		}
	}
}
