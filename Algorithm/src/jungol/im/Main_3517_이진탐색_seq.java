package jungol.im;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3517_이진탐색_seq {
	static int N;
	static int Q;
	static int[] numbers;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res\\jungol\\3517_이진탐색.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		numbers = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
			
		}
		
		Q = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < Q; i++) {
			int find = Integer.parseInt(st.nextToken());
			int j = 0;
			for(; j<N; j++) {
				if(find == numbers[j]) {
					System.out.print(j + " ");
					break;
				}
			}
			if(j>=N) {
				System.out.print(-1+" ");
			}
		}
		
		
		
		
	}

}
