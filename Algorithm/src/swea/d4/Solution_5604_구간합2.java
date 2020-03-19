package swea.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_5604_구간합2 {
	static long[] count;
	static long A, B;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/d4/5604_구간합.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			count = new long[10];
			long point = 1;
			
			while (A <= B) {
				while (A % 10 != 0 && A<=B) {
					cal(A, count, point);
					A++;
				}
				if(B<A) break;
				
				while (B % 10 != 9 && A<=B) {
					cal(B, count, point);
					B--;
				}

				A/=10;
				B/=10;
				for (int i = 0; i < 10; i++) {
					count[i] += (B-A+1)*point;
				}
				point*=10;
//				cal(A, B);
			}
			int sum = 0;
			for (int i = 0; i < 10; i++) {
				sum+= count[i]*i;
			}
			
			System.out.println("A, B : " + A + " " + B);
			System.out.println(Arrays.toString(count));
			System.out.println("#" + tc + " " + sum);
			
		}
	}

	private static void cal(long x, long[] count, long point) {
		while (x > 0) {
			String s = String.valueOf(x);
			int xx = s.charAt(s.length()-1)-'0'; // 49-48
			count[xx]+= point;
			x /= 10;
		}
	}
}
