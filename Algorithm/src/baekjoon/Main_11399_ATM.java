package HW;

import java.util.Arrays;
import java.util.Scanner;

public class Main_11399_ATM {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}			
		
		Arrays.sort(arr);
		int hap = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= i; j++) {
				hap += arr[j];
			}
		}
		System.out.println(hap);
	}
}
