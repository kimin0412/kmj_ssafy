package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1461_도서관 {
	static int N, M, ans;
	static PriorityQueue<Integer> pluBooks;
	static PriorityQueue<Integer> minuBooks;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		String c = st.nextToken();
		pluBooks = new PriorityQueue<Integer>();
		minuBooks = new PriorityQueue<>(Collections.reverseOrder());
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			int pos = Integer.parseInt(st.nextToken());
			if(pos>0)
				pluBooks.add(pos);
			else
				minuBooks.add(pos);
		}
		
		System.out.println(pluBooks.toString());
		System.out.println(minuBooks.toString());
		
		while(!minuBooks.isEmpty()) {
			System.out.println(minuBooks.poll());
		}
		
		ans = 0;

		System.out.println(ans);
	}
}