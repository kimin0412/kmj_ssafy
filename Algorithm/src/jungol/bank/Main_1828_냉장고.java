package jungol.bank;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main_1828_냉장고 {
	
	public static class NN{
		
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("res/jungol/1828_냉장고.txt"));
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr = new int[N][2];
		int[] ccha = new int[N];
		int max = 0;
		for (int i = 0; i < N; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
			int cha = arr[i][1] - arr[i][0];
		}
		
//		Arrays.sort

	}

}
