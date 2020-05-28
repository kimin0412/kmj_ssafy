package swea.swtest;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_4013_모의SW_특이한자석_수업 {
	static int K;
	static int[][] mag;
	static LinkedList<Integer>[] magQ;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/sw/4013_모의SW_특이한자석.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			K = Integer.parseInt(st.nextToken()); // 회전 횟수

			magQ = new LinkedList[5]; // 1, 2, 3, 4 번 자석
			for (int i = 1; i <= 4; i++) {
				magQ[i] = new LinkedList<>(); // 맵
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < 8; j++) {
					magQ[j].add(Integer.parseInt(st.nextToken())); // i번 자석의 8개의 톱니정보 입력
				}
			}

			for (int k = 0; k < K; k++) { // K번 자석을 돌려봅시다!
				st = new StringTokenizer(br.readLine(), " ");
				int mNum = Integer.parseInt(st.nextToken()); // 몇번 자석을?
				boolean dir = Integer.parseInt(st.nextToken()) == 1 ? true : false; // 1이면 시계 true, 아니면 반시계 false

				if (mNum > 1) { // 자기 오른쪽에 자석이 있는 애들
					action(mNum, 6, dir);
				}

				if (mNum > 1 && mNum < 4) { // 중간에 낀 2, 3번 자석은 rotate 두번 당하니까 한번 무효시키기
					rotate(mNum, !dir); // 두번 돌아갔으니까 반대 방향으로 돌려서 원상복구 시키기
				}

				if (mNum < 4) { // 자기 왼쪽에 자석이 있는 애들
					action(mNum, 2, dir);
				}
			}

			int sum = 0;
			for (int i = 1; i <= 4; i++) {
				sum += (magQ[i].get(0) * (1<<(i-1)));
			}
			System.out.println("#" + tc + " " + sum);
		}
	}

	static void action(int mNum, int idx, boolean dir) { // 자석번호, 왼쪽/오른쪽(2,6), 시계/반시계
		int mNext = mNum + (idx == 2 ? +1 : -1); // 2이면 오른쪽, 6이면 왼쪽으로 진행
		if (mNext > 0 && mNext < 5 && magQ[mNum].get(idx) != magQ[mNext].get((idx + 4) % 8)) {
			action(mNext, idx, !dir); // 옆좌석번호, 왼오 방향은 유지, 시계반시계 방향은 반대
		}
		rotate(mNum, dir); // 옆 자석을 돌릴지 말지 확인하고 났으면 이제 현재자석도 돌려야죠!
	}

	private static void rotate(int mNum, boolean dir) { // mNum번 자석을 true:시계, false:반시계
		if (dir) { // 시계방향
			magQ[mNum].addFirst(magQ[mNum].removeLast());
		} else { // 반시계 방향
			magQ[mNum].addLast(magQ[mNum].removeFirst());
		}
	}
}
