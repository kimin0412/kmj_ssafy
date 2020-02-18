package jungol.bank;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1459_숫자고르기 {
	static int[] index;
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("res/jungol/1459_숫자고르기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		index = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			index[i] = Integer.parseInt(br.readLine());
			if(i == index[i])
				index[i] = 0;
		}
		rotate(1);
		
	}

	private static void rotate(int i) {
//		if(index[i])
	}

}
