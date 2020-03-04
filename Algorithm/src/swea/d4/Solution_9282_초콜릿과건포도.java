package swea.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_9282_초콜릿과건포도 {
	static int result;
	static int N, M;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/d4/9282_초콜릿과건포도.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken()); // 중접 개수
			M = Integer.parseInt(st.nextToken()); // 간선 정보의 개수
			map = new int[N][M];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
//			사이즈가 정해져 있으면 
//			처리
			result = dfs(0, 0, N, M, Integer.MAX_VALUE);
//			출력
			System.out.println("#" + tc + " " + result);

		}

	}

	private static int dfs(int y, int x, int h, int w, int min) { // y, x, width, height
//		종료
		if (w == 1 && h == 1) { // 크기가 1이 됐을때 : 더 이상 조각을 낼수가 없을 때
			return 0;
		}
//		실행
//		기존에 있던 덩어리의 건포도 개수가 비용이 된다.
		int sum = 0;
		for (int i = y; i < y + h; i++) {
			for (int j = x; j < x + w; j++) {
				sum += map[i][j];
			}
		}
//		가로로 나누어서 최소비용을 구한다. 
//		각각의 사이즈들을 나누어준다.
		for (int i = 1; i < h; i++) { // 가로로 나눈다는 것은 높이값을 나누는것
//			위쪽의 비용
			int sum1 = dfs(y, x, i, w, min);
//			아래쪽 비용
			int sum2 = dfs(y + i, x, h - i, w, min);
//			기존의 비용 + 위쪽 비용 + 아래쪽 비용을 구한 후 최솟값을 구한다.
			int sum3 = sum + sum1 + sum2; // 건포도의 개수
			min = Math.min(min, sum3);
		}

//		세로로 나누어서 최소비용을 구한다. 
		for (int i = 1; i < w; i++) { // 한줄씩 잘라줄거기 때문에 1로 시작
//			왼쪽 비용
			int sum1 = dfs(y, x, h, i, min);
//			오른쪽 비용 
			int sum2 = dfs(y, x + i, h, w - i, min);
			int sum3 = sum + sum1 + sum2; // 건포도의 개수 
			min = Math.min(min, sum3);
		}

//		재귀호출
		return min;
	}
}