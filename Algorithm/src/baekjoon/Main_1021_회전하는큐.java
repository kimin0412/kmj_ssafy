package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1021_회전하는큐 {
	static int N;
	static List<Integer>[] map;
	static int[] count;
	static boolean flag;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			map[i] = new ArrayList<Integer>();
		}

		for (int i = 1; i <= N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a].add(b);
			map[b].add(a);
		}

		count = new int[N + 1];
		for (int i = 2; i <= N; i++) {
			
		}

		flag = false;
//		System.out.print(flag ? cnt : -1);
	}

}