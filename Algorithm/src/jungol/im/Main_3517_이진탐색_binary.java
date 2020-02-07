package jungol.im;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3517_이진탐색_binary {
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
			System.out.print(binary(find, 0, N-1)+ " ");
		}
	}
	private static int binary(int find, int start, int end) {
//		못찾은 경우
		if(start>end) return -1;
		
//		중앙값 찾기
		int mid = (start+end) >> 1;
//		비교해서 
		int data = numbers[mid];
//		같은면 mid index 리턴
		if(find == data) {
			return mid;
		}else if(find < data) {
//		작으면 왼쪽에서 찾기
			return binary(find, start, mid);
		}else {
//		크면 오른쪽에서 찾기
			return binary(find, mid+1, end);
		}
		//중앙값 찾기로 돌아가야하는데 재귀로 짤거임	
	}
}
