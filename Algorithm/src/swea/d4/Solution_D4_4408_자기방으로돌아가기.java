package swea.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution_D4_4408_자기방으로돌아가기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("res/swea/d4/4408_자기방으로돌아가기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine().trim());
			int[][] room = new int[N][3];
			int[] check = new int[201];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				room[i][0] = Integer.parseInt(st.nextToken());
				room[i][1] = Integer.parseInt(st.nextToken());
				room[i][2] = Math.abs(room[i][0] - room[i][1]);
			}

			Arrays.sort(room, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					if (o1[2] > o2[2])
						return 1;
					else if (o1[2] == o2[2]) {

						return 0;
					} else
						return -1;
				}
			});

			int cnt = 0;
			int su = 0;
			int now, after;
			boolean flag = true;
			
			while(cnt != N) {
				su++;
				check = new int[201];
				for (int i = 0; i < N; i++) {
					flag = true;
					if (room[i][0] != 0) {
						now = room[i][0];
						after = room[i][1];
						
						//값 교환
						if (now > after) {
							int tmp = now;
							now = after;
							after = tmp;
						}

						for (int j = (now + 1) / 2; j <= (after + 1) / 2; j++) {
							if (check[j] == 1) {
								flag = false;
								break;
							}
						}
						
						if(flag == true) {
							for (int j = (now + 1) / 2; j <= (after + 1) / 2; j++) {
								check[j] = 1;
							}
							room[i][0] = 0;
							cnt++;
						}
							
						else {
							continue;
						}
					}

				}
			}

			System.out.println(su);
		}
			
	}

}
