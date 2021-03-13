package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_2457_공주님의정원_풀이 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<int[]> flowers = new PriorityQueue<int[]>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] < o2[0]) {
					return 1;
				} else if (o1[0] == o2[0]) {
					if (o1[1] < o2[1])
						return 1;
					else
						return -1;
				} else
					return 1;
			}
		});

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			flowers.add(new int[] { a * 100 + b, c * 100 + d });
		}

		for (int[] is : flowers) {
			System.out.print(is[0] + " " + is[1]);
			System.out.println();
		}

		boolean flag1 = false;
		boolean flag2 = false;
		final int START_DATE = 301;
        final int END_DATE = 1201;
		int idx = 1231;

		while (!flowers.isEmpty()) {
			int[] p = flowers.poll();
			if (!flag1) {
				if (p[0] <= 301) {
					flag1 = true;
					idx = p[1];
				}
			}
			else {
				if(p[1] > idx) {
					
				}
			}
//			if (p[1] >= 1201) {
//				flag2 = true;
//			}

		}

//		for (int[] is : flowers) {
//			System.out.print(is[0] + " " + is[1]);
//			System.out.println();
//		}

//		boolean flag1 = false;
//		boolean flag2 = false;
//
//		int mM1 = 0;
//		int mD1 = 0;
//		int mM2 = 13;
//		int mD2 = 32;
//
//		for (int i = 0; i < N; i++) {
//			if (flowers[i].sMon <= 2 || (flowers[i].sMon == 3 && flowers[i].sDay == 1)) {
//				flag1 = true;
//				if (flowers[i].fMon >= 12) {
//					flag2 = true;
//					break;
//				} else {
//					if (mM1 <= flowers[i].fMon && mD1 <= flowers[i].fDay) {
//						mM1 = flowers[i].fMon;
//						mD1 = flowers[i].fDay;
//					}
//				}
//			} else {
//				if (flowers[i].fMon >= 12) {
//					flag2 = true;
//					if (mM2 >= flowers[i].sMon && mD2 >= flowers[i].sDay) {
//						mM2 = flowers[i].sMon;
//						mD2 = flowers[i].sDay;
//					}
//				} else {
//					break;
//				}
//			}
//		}

	}

}