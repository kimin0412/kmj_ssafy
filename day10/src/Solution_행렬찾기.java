
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution_행렬찾기 {

	static class Rect implements Comparable<Rect> {
		int size;
		int r;
		int c;

		public Rect(int size, int r, int c) {
			this.size = size;
			this.r = r;
			this.c = c;
		}

		//사각형의 크기 비교, 크기가 같은 경우 행의 크기 비교
		@Override
		public int compareTo(Rect o) {
			int rr = size-o.size;
			if(rr==0) {
				rr = r - o.r;
			}
			return rr;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N + 2][N + 2];

			ArrayList<Rect> rectlist = new ArrayList<>();
					
			for (int i = 1; i < N + 1; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 1; j < N + 1; j++) {
					int val = Integer.parseInt(st.nextToken());
					// val = 0, 1~9

					// 현재 0이 아닌 칸이라면
					if (val != 0) {
						// 내 위에가 0이면 행렬시작, 왼쪽칸보다 +1
						if (map[i - 1][j] == 0)
							map[i][j] = map[i][j - 1] + 1;
						// 내위가 0이아니면 이미 행렬 안, 내 위에보다 + 100
						else
							map[i][j] = map[i - 1][j] + 100;
					}
				}
				/*
				 * 0000000 0 0 0 0 0 0 0 0345600 0 1 2 3 4 0 0 0987100 0 101 102 103 104 0 0
				 * 0000000 0 0 0 0 0 0 0
				 */

			} // 입력끝

			// 처리
			for (int i = 1; i < N + 1; i++) {
				for (int j = 1; j < N + 1; j++) {
					if (map[i][j] != 0 && map[i + 1][j] == 0 && map[i][j + 1] == 0) {
						int r = map[i][j] / 100 + 1;
						int c = map[i][j] % 100;
						rectlist.add(new Rect(r * c, r, c));
					}
				}
			}
			Collections.sort(rectlist);
			System.out.print("#" + tc + " " + rectlist.size() + " ");
			for (Rect rect : rectlist)
				System.out.print(rect.r + " " + rect.c + " ");
			System.out.println();

		} // tc
	}// main
}
