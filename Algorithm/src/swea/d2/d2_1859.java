package swea.d2;

import java.util.Scanner;

public class d2_1859 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			} //입력받기 끝
			
			int max = arr[N-1];
			long sum1 = 0, sum2 = 0;
			for (int i = N-2; i >= 0; i--) {
				if(max>arr[i])
				{
					sum1+=(max-arr[i]);
//					System.out.println(sum1);
				}
				else {
					sum2 += sum1;
					sum1 = 0;
					max = arr[i];
//					System.out.println(sum2);

				}
				
			}
			
			
			System.out.println("#"+test_case+" "+(sum2+sum1));
		}
	}
}

