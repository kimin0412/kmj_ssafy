package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_2457_공주님의정원 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Flower[] flowers = new Flower[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			flowers[i] = new Flower(a, b, c, d);
		}

		boolean flag1 = false;
		boolean flag2 = false;

		int mM1 = 0;
		int mD1 = 0;
		int mM2 = 13;
		int mD2 = 32;

		for (int i = 0; i < N; i++) {
			if (flowers[i].sMon <= 2 || (flowers[i].sMon == 3 && flowers[i].sDay == 1)) {
				flag1 = true;
				if (flowers[i].fMon >= 12) {
					flag2 = true;
					break;
				} else {
					if (mM1 <= flowers[i].fMon && mD1 <= flowers[i].fDay) {
						mM1 = flowers[i].fMon;
						mD1 = flowers[i].fDay;
					}
				}
			} else {
				if (flowers[i].fMon >= 12) {
					flag2 = true;
					if (mM2 >= flowers[i].sMon && mD2 >= flowers[i].sDay) {
						mM2 = flowers[i].sMon;
						mD2 = flowers[i].sDay;
					}
				} else {
					break;
				}
			}
		}
		
	}

	public static class Flower {
		int sMon;
		int sDay;
		int fMon;
		int fDay;

		public Flower(int sMon, int sDay, int fMon, int fDay) {
			super();
			this.sMon = sMon;
			this.sDay = sDay;
			this.fMon = fMon;
			this.fDay = fDay;
		}
	}

}