package swea.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_4050_재관이의대량할인 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/d4/4050_재관이의대량할인.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");
			LinkedList<Integer> list = new LinkedList<Integer>();
			
			for (int i = 0; i < N; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			Collections.sort(list, Collections.reverseOrder());
			
			int sum = 0;
			while(!list.isEmpty()) {
				if(list.size() < 3) {
					sum+=list.pollLast();
				}
				else {
					sum+=list.pollFirst();
					sum+=list.pollFirst();
					list.pollFirst();
				}
			}
			System.out.println("#" + tc + " " + sum);
		}
	}
}
