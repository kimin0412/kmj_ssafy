package swea.ws;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_1225_암호생성기 {
	public static void main(String[] args) throws Exception {
//		int N = 20;
		System.setIn(new FileInputStream("res/1225_암호생성기.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = 8;
		// Integer.ParseInt(s) : 정수 포맷의 문자열을 정수로 변환시켜주는 함수
		int cnt = 1;
		for (int i = 0; i < 10; i++) {
			cnt = 1;
			LinkedList<Integer> que = new LinkedList<>();
			in.readLine();
//			String line = in.readLine();
//			line.split(" ");
			StringTokenizer st = new StringTokenizer(in.readLine(), " "); // 데이터를 기준으로 자를때에는 우리가 명시적으로 구분자를 주는게 좋다.
			for (int j = 0; j < N; j++) {
				que.offer(Integer.parseInt(st.nextToken()));
			}
//			System.out.println(que);

			while (true) {
				int p = que.poll();
				if (p - cnt <= 0) {
					que.offer(0);
//					System.out.println(que);
					break;
				} else {
					que.offer(p - cnt);
					cnt++;
					if(cnt == 6)
						cnt = 1;
				}
			}
			System.out.println(que);
		}

	}
}
