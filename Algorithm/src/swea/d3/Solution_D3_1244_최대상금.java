package swea.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution_D3_1244_최대상금 {
	static int N, K, max = 0;
	static String s = "";
	static int[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("res/swea/d3/1244_최대상금.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			s = st.nextToken();
			int l = s.length();
			K = Integer.parseInt(st.nextToken());
			arr = new int[l];
			for (int i = 0; i < l; i++) {
				arr[i] = s.charAt(i) - '0';
			}
			max = 0;
			s = "";
			dfs(0, 0);
			System.out.println(max);
		}
	}

	private static void dfs(int cnt, int ncnt) {
		if (cnt == K) {
			s = "";
			for (int i = 0; i < arr.length; i++) {
				s += arr[i];
			}
			max = Math.max(max, Integer.parseInt(s));
			return;
		}

		for (int i = ncnt; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				if (i == j)
					continue;
				if (arr[i] <= arr[j]) {
					int tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
					dfs(cnt + 1, i);
					tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
			}
		}
	}
}
