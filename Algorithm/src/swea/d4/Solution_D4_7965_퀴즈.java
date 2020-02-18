package swea.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.nio.Buffer;

public class Solution_D4_7965_퀴즈 {
	
	public static long dcPower(int x, int n) {
		if (n == 0)
			return 1; // 0승인 경우 1을 리턴
		if (n == 1)
			return x; // 0승인 경우 1을 리턴
		long result = dcPower(x, n >> 1) % 1000000007;
		if (n % 2 == 0) { // n이 홓수인 경우
			return (result*result) % 1000000007;
		}
		return (((result*result)% 1000000007)*x) % 1000000007;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("res/swea/d4/7965_퀴즈.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			long modhap = 0;
			int n = Integer.parseInt(br.readLine());
			for (int i = 1; i <= n; i++) {
				modhap += dcPower(i, i);
				modhap = modhap% 1000000007;
			}
			System.out.println(modhap);
		}
	}
}
