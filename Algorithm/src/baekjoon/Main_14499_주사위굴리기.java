package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14499_주사위굴리기 {
	static int N, M, r, c, K;
	static int[][] map;
	static int[] order;
	static int[] diceValue;

	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("res/baekjoon/14499_주사위굴리기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
//		int T = Integer.parseInt(br.readLine());
//		for (int tc = 1; tc <= T; tc++) {

			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			map = new int[N][M];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());

				}
			}

			order = new int[K];
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < K; i++) {
				order[i] = Integer.parseInt(st.nextToken());
			}

			// 위, 북, 왼, 바, 남, 오
			diceValue = new int[6];

			for (int i = 0; i < K; i++) {
				diceMove(order[i]);
			}
		}

//	}

	private static void diceMove(int o) {
		int tmpR = r, tmpC = c;
		switch (o) {
		case 1: // 동
			tmpC++;
			break;
		case 2: // 서
			tmpC--;
			break;
		case 3: // 북
			tmpR--;
			break;
		case 4: // 남
			tmpR++;
			break;
		}
		if (!(-1 < tmpR && tmpR < N && -1 < tmpC && tmpC < M)) {
			return;
		}
		r = tmpR;
		c = tmpC;

		int[] diceTmp = new int[6];
		switch (o) {
		case 1: // 동
			diceTmp[4] = diceValue[4];
			diceTmp[1] = diceValue[1];
			diceTmp[3] = diceValue[5];
			diceTmp[2] = diceValue[3];
			diceTmp[5] = diceValue[0];
			diceTmp[0] = diceValue[2];
			break;
		case 2: // 서
			diceTmp[4] = diceValue[4];
			diceTmp[1] = diceValue[1];
			diceTmp[5] = diceValue[3];
			diceTmp[3] = diceValue[2];
			diceTmp[0] = diceValue[5]; //
			diceTmp[2] = diceValue[0];
			break;
		case 3: // 북
			diceTmp[2] = diceValue[2];
			diceTmp[5] = diceValue[5];
			diceTmp[3] = diceValue[1];
			diceTmp[4] = diceValue[3];
			diceTmp[0] = diceValue[4];
			diceTmp[1] = diceValue[0];
			break;
		case 4: // 남
			diceTmp[2] = diceValue[2];
			diceTmp[5] = diceValue[5];
			diceTmp[1] = diceValue[3];
			diceTmp[3] = diceValue[4];
			diceTmp[4] = diceValue[0];
			diceTmp[0] = diceValue[1];
			break;
		}
		diceValue = diceTmp;

		if (map[r][c] != 0) {
			diceValue[3] = map[r][c];
			map[r][c] = 0;
		} else {
			map[r][c] = diceValue[3];
		}
		System.out.println(diceValue[0]);
	}

}
