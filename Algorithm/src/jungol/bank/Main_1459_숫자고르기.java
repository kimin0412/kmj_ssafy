package jungol.bank;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.SortedSet;
import java.util.StringTokenizer;

public class Main_1459_숫자고르기 {
	static int[] visit;
	static int N;
	static int[] p;

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("res/jungol/1459_숫자고르기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		p = new int[N + 1];
		visit = new int[N + 1];
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			p[i] = Integer.parseInt(br.readLine());
		}

		for (int i = 1; i <= N; ++i) {
			if (rotate(i))
				visit[i] = visit[p[i]] = 1;
		}

		int sum = 0;
		for (int i = 1; i <= N; ++i)
			if (visit[i] == 1)
				sum++;
		System.out.println(sum);
		for (int i = 1; i <= N; ++i)
			if (visit[i] == 1)
				System.out.println(i);
	}

	private static boolean rotate(int idx) {
		int first = idx; // 초기값
		int second = p[idx];
		for (int i = 0; i < N; ++i) {
			if (first == second)
				return true;
			second = p[second];
		}
		return false;
	}
}
