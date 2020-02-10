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
//방문노드 필요없게 한것
public class S1_2667_단지번호붙이기2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("res/beakjun/bfs/2667"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[][] map = new int[N][N]; // 맵정보 이면서 반문 처리할 배열
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
				if (map[i][j] == 1) {  //1이라는거 자체가 방문을 안한 노드라는것
					map[i][j] = ++no;
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
								map[nr][nc] == 1) {// 상하좌우에 인접된 아파트이면서
								map[nr][nc] = no;
								queue.offer(new int[] { nr, nc });
							}
						}
					}
//					no++;  //앞에서 처리했기 때문에 또 넣을 필요가 없다.
				}
			}
		}
		int[] count = new int[no + 1]; // 단지 번호 0번부터 1번은 사용안함
		System.out.println(--no); // 단지 넘버

		// 단지에 있는 아파트 세기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] > 0) {// 단지 번호가 붙은 아파트만
					count[map[i][j]]++; //카운트 세기
				}
			}
		}
		Arrays.sort(count);
		for (int i = 2; i <= no+1; i++) {  //2번부터 no+1까지
			System.out.println(count[i]);

		}
	}
}
