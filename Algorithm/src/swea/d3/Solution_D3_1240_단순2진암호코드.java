package swea.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D3_1240_단순2진암호코드 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("res/swea/d3/1240_단순2진암호코드.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[][] map = new int[N][M];
			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				for (int j = 0; j < M; j++) {
					map[i][j] = s.charAt(j) - '0';
				}
			}

			int starti = 0;
			int startj = 0;

			top: for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][M - j - 1] == 1) {
						startj = M - j - 56;
						starti = i;
						break top;
					}
				}
			}

			int cnt = 0;
			int flag = map[starti][startj - 1];

			int[] code = new int[8];

			String count = "";
			cnt = 0;
			int n = 1;

			for (int j = startj; j < startj + 56; j++) {
				cnt++;
				count += map[starti][j];
				if (cnt % 7 == 0) {
					switch (count) {
					case "0001101":
						code[cnt / 7 - 1] = 0;
						break;
					case "0011001":
						code[cnt / 7 - 1] = 1;
						break;
					case "0010011":
						code[cnt / 7 - 1] = 2;
						break;
					case "0111101":
						code[cnt / 7 - 1] = 3;
						break;
					case "0100011":
						code[cnt / 7 - 1] = 4;
						break;
					case "0110001":
						code[cnt / 7 - 1] = 5;
						break;
					case "0101111":
						code[cnt / 7 - 1] = 6;
						break;
					case "0111011":
						code[cnt / 7 - 1] = 7;
						break;
					case "0110111":
						code[cnt / 7 - 1] = 8;
						break;
					case "0001011":
						code[cnt / 7 - 1] = 9;
						break;

					}
					flag = map[starti][j];
					count = "";
				}
			}

			int haphol = 0;
			int hap = 0;
			for (int i = 0; i < 8; i++) {
				if (i % 2 == 0) {
					haphol += code[i] * 3;
				}
				if (i % 2 == 1)
					hap += code[i];
			}

			if ((hap + haphol) % 10 == 0) {
				System.out.println("#" + (tc + 1) + " " + (hap + haphol / 3));
			} else
				System.out.println("#" + (tc + 1) + " " + 0);

		}
	}
}
