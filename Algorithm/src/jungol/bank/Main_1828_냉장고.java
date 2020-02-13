package jungol.bank;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main_1828_냉장고 {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("res/jungol/1828_냉장고.txt"));
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr = new int[N][2];
		for (int i = 0; i < N; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}

		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] > o2[0])
					return 1;
				else if (o1[0] == o2[0]) {
					if (o1[1] < o2[1])
						return 1;
					else if (o1[1] == o2[1])
						return 0;
					else
						return -1;
				} else
					return -1;
			}
		});

		int cnt = 1;
		int s = arr[0][0], e = arr[0][1];
		for (int i = 1; i < N; i++) {
			if (s > arr[i][1] || e < arr[i][0]) {
				cnt++;
				s = arr[i][0];
				e = arr[i][1];
			}
			else {
				if (s <= arr[i][0])
					s = arr[i][0];
				if (arr[i][1] <= e)
					e = arr[i][1];
			}


		}
		System.out.println(cnt);

	}
}
