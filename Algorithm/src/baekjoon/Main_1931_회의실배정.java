package baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_1931_회의실배정 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("res/baekjoon/1931.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1] < o2[1])
					return -1;
				else if (o1[1] == o2[1]) {
					if (o1[0] < o2[0])
						return -1;
					else if (o1[0] == o2[0])
						return 0;
					else
						return 1;
				} else
					return 1;
			}
		});
		
		/**
		 * if (o1[0] - o2[1] == 0) return o1[0] - o2[0];
		 * else return o1[0] - o2[0];
		 */

		int cnt = 0;
		int endt = 0;
		for (int i = 0; i < N; i++) {
			if (endt <= arr[i][0]) {
				cnt++;
				endt = arr[i][1];
			} 

		}

		System.out.println(cnt);

	}

}
