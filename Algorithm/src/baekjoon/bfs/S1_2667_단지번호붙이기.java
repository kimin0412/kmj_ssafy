package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

import com.ssafy.stack.StackTest_API;

public class S1_2667_단지번호붙이기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("res/beakjun/bfs/2667"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[][] map = new int[N][N]; // 맵정보
		int[][] visit = new int[N][N]; // 방문정보
		int no = 1; // 단지 번호

		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = line.charAt(j) - '0'; // 문자데이터이기 때문에 0버리면서 입력하면됨
			}
		}

		LinkedList<int[]> queue = new LinkedList<>(); // 상하좌우로 가기위해 int[]로 선언
//							상		  하			좌			우
		int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
//		배열을 탐색하면서 
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 0이 아닌 아파트를 찾고, 방문 안한 아파트를 찾았으면
				if (map[i][j] != 0 && visit[i][j] == 0) {
					visit[i][j] = no;
				// 인접 아파트를 찾기위해 BFS로 검색
				queue.offer(new int[] { i, j });
				while (!queue.isEmpty()) {
					int[] node = queue.poll(); // 현재 방문 노드
					int r = node[0];
					int c = node[1];
					for (int k = 0; k < 4; k++) { // 상하좌우에 인접된 아파트이면서 방문안한 아파트 찾기
						int nr = r + dir[k][0];
						int nc = c + dir[k][1];
						// 경계 안에 있으면서
						if (nr > -1 && nr < N && nc > -1 && nc < N && 
								map[nr][nc] != 0 && visit[nr][nc] == 0) {// 상하좌우에 인접된 아파트이면서 방문안한 아파트
								visit[nr][nc] = no;
								queue.offer(new int[] { nr, nc });
							}
						}
					}
					no++;
				}
			}
		}
		System.out.println(--no); // 단지 넘버
		int[] count = new int[no + 1]; // 단지 번호가 1번 부터의 0번 배열은 사용 안함

		// 단지에 있는 아파트 세기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visit[i][j] > 0) {// 단지 번호가 붙은 아파트만
					count[visit[i][j]]++; //카운트 세기
				}
			}
		}
		Arrays.sort(count);
		for (int i = 1; i <= no; i++) {
			System.out.println(count[i]);

		}
	}
}
