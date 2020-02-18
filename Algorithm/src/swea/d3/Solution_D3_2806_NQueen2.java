package swea.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_D3_2806_NQueen2 {
	static int cnt;
	static int[] visit;
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("res/swea/d3/2806_NQueen.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			cnt = 0;
			N = Integer.parseInt(br.readLine());
			visit = new int[N];
			backtraking(0);
			System.out.println(cnt);
		}
	}

	private static void backtraking(int Q) {
		if (Q == N) {
			cnt++;
			return;
		}

		for (int i = 0; i < N; i++) {
			visit[Q] = i; // Q은 행, i는 열값
			if (isPromising(Q)) {
				backtraking(Q + 1);
			}
		}
	}

	private static boolean isPromising(int Q) {
		for (int i = 0; i < Q; i++) {
			if (visit[i] == visit[Q])
				return false; // 같은 열
			// 대각선 검사
			// 대각선은 행의 높이 차이만큼 열의 차이가 있음
			if (Math.abs(i - Q) == Math.abs(visit[i] - visit[Q]))
				return false;
		}
		return true;
	}
}
