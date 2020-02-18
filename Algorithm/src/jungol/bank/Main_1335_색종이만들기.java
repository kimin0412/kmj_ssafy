package jungol.bank;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1335_색종이만들기 {
	static int[] sorted;
	static int acnt = 0;
	static int bcnt = 0;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/jungol/1335.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		divide(map, 0, 0, N, N);
		System.out.println(acnt);
		System.out.println(bcnt);
	}

	private static void divide(int[][] map, int sr, int sc, int er, int ec) {
		int cha = er - sr;

		if (er - sr == 1) {
			if (map[sr][sc] == 0)
				acnt++;
			else
				bcnt++;
			return;
		}
		if (check(map, sr, sc, er, ec)) {
			if (map[sr][sc] == 0)
				acnt++;
			else
				bcnt++;
			return;
		}

		divide(map, sr, sc, er - cha / 2, ec - cha / 2);
		divide(map, sr, sc + cha / 2, er - cha / 2, ec);
		divide(map, sr + cha / 2, sc, er, ec - cha / 2);
		divide(map, sr + cha / 2, sc + cha / 2, er, ec);
	}

	private static boolean check(int[][] map, int sr, int sc, int er, int ec) {
		boolean flag = true;
		int c = map[sr][sc];
		top: for (int i = sr; i < er; i++) {
			for (int j = sc; j < ec; j++) {
				if (c != map[i][j]) {
					flag = false;
					break top;
				}
			}
		}
		return flag;
	}
}
