
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17471_게리멘더링 {
	static int N, K, Min, sum, partsum;
	static int[] peo;
	static int[][] link;
	static boolean[] check;
	static int[] temp;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/17471_게리맨더링.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 구역갯수
		peo = new int[N + 1];// 구역의 인구
		link = new int[N + 1][N + 1];
        /*
0000000
0000000
0000000
0000000
0000000
0000000
0000000
         */
        
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);

		// 구역별 인구수 입력
		for (int i = 1; i < N + 1; i++) {
			peo[i] = Integer.parseInt(st.nextToken());
		} // peo={0 5 2 3 4 1 2};

		// 구역별 연결을 이차원 배열로 표현 , 각 구역과 인접한 구역
		for (int x = 1; x < N + 1; x++) {
			s = br.readLine();
			st = new StringTokenizer(s);
			int each = Integer.parseInt(st.nextToken());
			for (int y = 0; y < each; y++) {
				int spot = Integer.parseInt(st.nextToken());
				link[x][spot] = 1;
			}
		}
/*
0000000
0010100   2 2 4
0101011   4 1 3 6 5
0010100   2 4 2
0101000   2 1 3
0010000   1 2
0010000   1 2       
 */
		Min = Integer.MAX_VALUE;

		// 부분집합 구하기
		for (int i = 0; i < (N / 2) + 1; i++) {
			K = i;
			check = new boolean[N + 1];
			pick(1, 0);
		}

		if (Min == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(Min);
		}
	}// main
    
    
	public static void pick(int start, int cnt) {// 1,0

		if (cnt == K) {
			sum = Integer.MAX_VALUE;
			temp = new int[N + 1];

			// 부분집합 선택된 숫자는 temp 1, 선택안되면 0
			// 두 구역 분리
			for (int i = 1; i < N + 1; i++) {
				if (check[i] == true) {
					temp[i] = 1;
				} else {
					temp[i] = 0;
				}
			}
			confirm();
			Min = Math.min(Min, sum);
			return;
		}
		for (int i = start; i < N + 1; i++) {
			check[i] = true;
			pick(i + 1, cnt + 1);
			check[i] = false;
		}
	}

	public static void confirm() {
		// 모든 지역구가 나눠지는지 확인하는 배열
		visited = new boolean[N + 1];
		int people1 = 0;
		int people2 = 0;

		// 연결된 곳을 gary메소드를 통해 재귀로 찾기
		for (int i = 1; i < N + 1; i++) {
			if (temp[i] == 1 && !visited[i]) {
				partsum = 0;
				gary(i);
				people1 = partsum;
				break;
			}
		}

		for (int i = 1; i < N + 1; i++) {
			if (temp[i] == 0 && !visited[i]) {
				partsum = 0;
				gary(i);
				people2 = partsum;
				break;
			}
		}

		// 한곳이라도 방문하지 않은 곳이 있다면 리턴 종료
		for (int i = 1; i < N + 1; i++) {
			if (!visited[i]) {
				return;
			}
		}
		sum = Math.abs(people2 - people1);
	}

	public static void gary(int x) {
		visited[x] = true;
		partsum = partsum + peo[x];
		for (int i = 1; i < N + 1; i++) {

			// 방문했는지 같은 지역구에 속했는지 연결이 되어있는 지역인지 검사
			if (!visited[i] && temp[i] == temp[x] && link[i][x] == 1) {
				gary(i);
			}
		}
	}

}
