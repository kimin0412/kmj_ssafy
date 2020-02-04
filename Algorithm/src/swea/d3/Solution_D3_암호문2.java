package swea.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_D3_암호문2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("res/암호문2.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		LinkedList<Integer> que = new LinkedList<>();
		StringTokenizer st;
		for (int i = 0; i < 10; i++) {
			int N = Integer.parseInt(in.readLine());
			st = new StringTokenizer(in.readLine(), " "); // 데이터를 기준으로 자를때에는 우리가 명시적으로 구분자를 주는게 좋다.
			for (int j = 0; j < N; j++) {
				que.offer(Integer.parseInt(st.nextToken()));
			}

			int order = Integer.parseInt(in.readLine());
			st = new StringTokenizer(in.readLine(), " "); // 데이터를 기준으로 자를때에는 우리가 명시적으로 구분자를 주는게 좋다.
			for (int j = 0; j < order; j++) {
				String c = st.nextToken();
				if (c.equals("I")) {
					int pos = Integer.parseInt(st.nextToken());
					int n = Integer.parseInt(st.nextToken());
					for (int k = 0; k < n; k++) {
						int a = Integer.parseInt(st.nextToken());
						que.add(pos + k, a);
					}
				}
				else if(c.equals("D")) {
					int pos = Integer.parseInt(st.nextToken());
					int n = Integer.parseInt(st.nextToken());
					for (int k = 0; k < n; k++) {
						que.remove(pos);
					}
				}
			}
			System.out.print("#" + (i + 1) + " ");
			for (int j = 0; j < 10; j++) {
				System.out.print(que.poll() + " ");
			}
			System.out.println();
			que.clear();
		}

	}

}
