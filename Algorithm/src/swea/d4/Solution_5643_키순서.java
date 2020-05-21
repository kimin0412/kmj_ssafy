package swea.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5643_키순서 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/d4/5643_키순서.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine().trim());
			int M = Integer.parseInt(br.readLine().trim());
			int[][] D = new int[N][N];

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine().trim(), " ");
				int a = Integer.parseInt(st.nextToken()) - 1;
				int b = Integer.parseInt(st.nextToken()) - 1;
				D[a][b] = 1;
			}

			for (int k = 0; k < D.length; k++) { // 경유 정점
				for (int i = 0; i < D.length; i++) { // 출발 정점
					if (k == i)
						continue;
					for (int j = 0; j < D.length; j++) { // 도착 정점
						if (k == j || i == j)
							continue;
						if (D[i][k] == 1 && D[k][j] == 1)
							D[i][j] = 1;
					}
				}
			}

			int hap = 0;
			for (int i = 0; i < N; i++) {
				int cnt = 0;
				for (int j = 0; j < N; j++) {
					if (i == j)
						continue;
					if (D[i][j] == 1 || D[j][i] == 1) {
						cnt++;
					}
				}
				if (cnt == N - 1) {
					System.out.println(i + 1);
					hap++;
				}
			}

			for (int i = 0; i < D.length; i++) {
				for (int j = 0; j < D.length; j++) {
					System.out.print(D[i][j] + " ");
				}
				System.out.println();
			}

			System.out.println("#" + tc + " " + hap);
		}
	}

}
