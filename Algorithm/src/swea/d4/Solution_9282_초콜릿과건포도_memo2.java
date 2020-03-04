package swea.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_9282_초콜릿과건포도_memo2 {
	static int result;
	static int N, M;
	static int[][] map;
	static int[][][][] dp; // 최소값을 저장해놓을 저장공간, 공간에 대한 x, y, w, h에 대한 맵

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
			dp = new int[N + 1][M + 1][N + 1][M + 1]; // 자르다보면 경계검사 해야하므로 1더 크게잡는다.
			for (int[][][] d1 : dp) {
				for (int[][] d2 : d1) {
					for (int[] d3 : d2) {
						Arrays.fill(d3, Integer.MAX_VALUE); // 최소값 비교해야하므로 최대값으로 초기화 시켜줌
					}
				}
			}

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
//			사이즈가 정해져 있으면 
//			처리
			result = dfs(0, 0, N, M); // 최소값 저장하는 맵이 있으므로 최소값 전달하는 매개변수 필요없다.
//			출력
			System.out.println("#" + tc + " " + result);

		}

	}

	private static int dfs(int y, int x, int h, int w) { // y, x, width, height
//		종료
		if (w == 1 && h == 1) { // 크기가 1이 됐을때 : 더 이상 조각을 낼수가 없을 때
			return 0;
		}
//		메모이제이션을 사용하므로 종료조건이 추가되어야함 
		if (dp[y][x][h][w] != Integer.MAX_VALUE) { // 한번이라도 작업이 이루어져있지 않으
			return dp[y][x][h][w];
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
			if (dp[y][x][i][w] == Integer.MAX_VALUE) {
				dp[y][x][i][w] = dfs(y, x, i, w);
			}
//			아래쪽 비용
			if (dp[y + i][x][h - i][w] == Integer.MAX_VALUE) {
				dp[y + i][x][h - i][w] = dfs(y + i, x, h - i, w);
			}
//			기존의 비용 + 위쪽 비용 + 아래쪽 비용을 구한 후 최솟값을 구한다.
			int sum3 = sum + dp[y][x][i][w] + dp[y + i][x][h - i][w]; // 건포도의 개수
			dp[y][x][h][w] = Math.min(dp[y][x][h][w], sum3);
		}

//		세로로 나누어서 최소비용을 구한다. 
		for (int i = 1; i < w; i++) { // 한줄씩 잘라줄거기 때문에 1로 시작
//			왼쪽 비용
			if (dp[y][x][h][i] == Integer.MAX_VALUE) {
				dp[y][x][h][i] = dfs(y, x, h, i);
			}
//			오른쪽 비용 
			if (dp[y][x + i][h][w - i] == Integer.MAX_VALUE) {
				dp[y][x + i][h][w - i] = dfs(y, x + i, h, w - i);
			}
			int sum3 = sum + dp[y][x][h][i] + dp[y][x + i][h][w - i]; // 건포도의 개수
			dp[y][x][h][w] = Math.min(dp[y][x][h][w], sum3);
		}

//		재귀호출
		return dp[y][x][h][w];
	}
}
