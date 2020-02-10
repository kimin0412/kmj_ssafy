package baekjoon.dfs;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

import com.ssafy.stack.StackTest_API;

//방문노드 필요없게 한것
public class S1_2667_단지번호붙이기2 {
	static int N;
	static int no = 1;
	static int[][] map;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("res/baekjoon/bfs/2667"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine()); // 백준은 입력 잘 받아와지는데 정올은 가끔 맨뒤에 공백이 붙는 경우가 있어서 trim을 해주어야한다.
		map = new int[N][N];

		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = line.charAt(j) - '0'; // 문자데이터이기 때문에 0버리면서 입력하면됨
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) { // 단지 번호가 부여되지 않은 아파트
					map[i][j] = ++no;
					dfs(i, j, no);
				}
			}
		}
		dfs(0, 0, no);

		int[] count = new int[no + 1]; // 단지 번호 0번부터 1번은 사용안함
		System.out.println(--no); // 단지 넘버

		// 단지에 있는 아파트 세기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] > 0) {// 단지 번호가 붙은 아파트만
					count[map[i][j]]++; // 카운트 세기
				}
			}
		}
		Arrays.sort(count);
		for (int i = 2; i <= no + 1; i++) { // 2번부터 no+1까지
			System.out.println(count[i]);

		}
	}

	private static void dfs(int r, int c, int no) {
		for (int i = 0; i < 4; i++) {
			int nr = r + dir[i][0];
			int nc = c + dir[i][1];
			if (nr > -1 && nr < N && nc > -1 && nc < N && map[nr][nc] == 1) {
				map[nr][nc] = no;
				dfs(nr, nc, no);
			}
		}

	}
}
