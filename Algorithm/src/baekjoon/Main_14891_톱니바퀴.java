package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_14891_톱니바퀴 {
	static int K;
	static int[][] mag;
	static LinkedList<Integer>[] magQ;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

//		st = new StringTokenizer(br.readLine(), " ");
		mag = new int[4][8]; // 맵
		magQ = new LinkedList[4];
		for (int i = 0; i < 4; i++) {
			magQ[i] = new LinkedList<Integer>(); // 맵
		}

		for (int r = 0; r < 4; r++) {
			String s = br.readLine();
			for (int c = 0; c < 8; c++) {
				mag[r][c] = s.charAt(c) - '0';
				magQ[r].add(mag[r][c]);
			}
		} // 맵 입력 받기
			// index 0 이 빨간화살표 위치
		K = Integer.parseInt(br.readLine()); // 회전 횟수

		for (int i = 0; i < K; i++) {
			int no;
			int cw;
			st = new StringTokenizer(br.readLine(), " ");
			no = Integer.parseInt(st.nextToken()) - 1;
			cw = Integer.parseInt(st.nextToken());
			rotate(no, cw);
		}
		int sum = 0;
		for (int i = 0; i < 4; i++) {
			sum += magQ[i].get(0) * Math.pow(2, i);
		}
		System.out.println(sum);
	}

	private static void rotate(int no, int cw) {

		boolean[] flag = new boolean[4];
		flag[no] = true;

		for (int i = no; i < 3; i++) {
			int poleR = magQ[i].get(2);
			if (poleR != magQ[i + 1].get(6)) {
				flag[i] = true;
				flag[i + 1] = true;
//				poleR = magQ[i].get(2);
			} else
				break;
		}

		for (int i = no; i > 0; i--) {
			int poleL = magQ[i].get(6);
			if (poleL != magQ[i - 1].get(2)) {
				flag[i] = true;
				flag[i - 1] = true;
//				poleL = magQ[i].get(6);
			} else
				break;
		}

		int dir = cw;
		for (int i = no; i < 4; i++) {
			if (flag[i]) {
				if (dir == 1) {
					int tmp = magQ[i].pollLast();
					magQ[i].addFirst(tmp);
					dir *= -1;
				} else {
					int tmp = magQ[i].pollFirst();
					magQ[i].addLast(tmp);
					dir *= -1;
				}
			}
		}
		dir = cw * -1;
		for (int i = no - 1; i > -1; i--) {
			if (flag[i]) {
				if (dir == 1) {
					int tmp = magQ[i].pollLast();
					magQ[i].addFirst(tmp);
					dir *= -1;
				} else {
					int tmp = magQ[i].pollFirst();
					magQ[i].addLast(tmp);
					dir *= -1;
				}
			}
		}
	}
}