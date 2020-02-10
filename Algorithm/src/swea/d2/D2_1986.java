package swea.d2;

import java.util.Scanner;

public class D2_1986 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n = sc.nextInt();
			int sum = 0;
			for (int i = 1; i < n+1; i++) {
				if(i%2 == 0)
					sum-=i;
				else
					sum+=i;
				
			}
			System.out.println(sum);
		}
	}
}
