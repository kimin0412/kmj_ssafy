package baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_5052_전화번호목록 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/baekjoon/Main_5052_전화번호목록.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < testcase; tc++) {
			int n = Integer.parseInt(br.readLine());
			long[] arr = new long[n];
			for (int i = 0; i < n; i++) {
				arr[i] = Long.parseLong(br.readLine());
			}
			Arrays.sort(arr);
			boolean flag = true;
			for (int i = 0; i < n - 1; i++) {
				String s1 = Long.toString(arr[i]);
				String s2 = Long.toString(arr[i + 1]);
				if (s2.indexOf(s1) == 0) {
					flag = false;
					break;
				}
			}
			System.out.println(flag ? "YES" : "NO");
		}
	}
}