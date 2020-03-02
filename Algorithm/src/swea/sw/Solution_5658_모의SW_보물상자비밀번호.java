package swea.sw;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_5658_모의SW_보물상자비밀번호 {
	static int N, K;
	static LinkedList<Character> hexa;
//	static LinkedList<Integer> hexa;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/sw/5658_모의SW_보물상자비밀번호.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			hexa = new LinkedList<>();
			int nn = N / 4;

			String line = br.readLine();
			for (int i = 0; i < N; i++) {

				char a = line.charAt(i);
//				int a = line.charAt(i) - '0';
//				if (a >= 17) {
//					a -= 7;
//				}
				hexa.offer(a);
			}

			System.out.println(hexa.toString());

			LinkedList<String> arr = new LinkedList<>();
//			int[][] arr = new int[12][nn];
//			int idx = 0;
			for (int i = 0; i < 3; i++) {
				String tmp = "";
//				int[] tmp = new int[nn];
				for (int j = 0; j < N; j++) {
					tmp += hexa.get(j);
					System.out.println(j + " " + tmp);
//					tmp[j % nn] = hexa.get(j);
//					arr[idx][(j + 1) % nn] = hexa.get(j);
//					hap += hexa.get(j) * Math.pow(16, nn - (j+1)%nn);
//					System.out.println(hap);
					if (j % nn == nn - 1) {
						boolean flag = true;
						for (int k = 0; k < arr.size(); k++) {
							if (arr.get(k).equals(tmp)) {
								flag = false;
								tmp = "";
								break;
							}
						}

						if (flag == true) {
							arr.offer(tmp);
//							idx++;
							tmp = "";
//							hap = 0;
						}
					}
				}
				char c = hexa.pollLast();
				hexa.offerFirst(c);

//				char c = hexa.pollLast();
//				hexa.offerFirst(c);

			}

			sort(arr, 0);
			for (String s : arr) {
				System.out.println(s);
			}

//			System.out.println(Arrays.toString(arr));
			System.out.println("#" + tc + " ");

		}
	}

	private static void sort(LinkedList<String> arr, int cur) {
//		if()
		
	}

}
