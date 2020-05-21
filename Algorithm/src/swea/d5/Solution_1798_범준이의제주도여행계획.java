package swea.d5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution_1798_범준이의제주도여행계획 {
	static int N, M, airport;
	static int[][] moveTime;
	static List<Place> placeInfo;
	static boolean[] visited;
	static int limitTime = 540;
	static int hotelCnt;
	static int[] hotels;
//	static 
	static int[] Crc, Hrc;
	private static int[][] points = null;
	static boolean[] visit;
	static int maxResult;

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("res/swea/d5/1798_범준이의제주도여행계획.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			maxResult = Integer.MIN_VALUE;
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			moveTime = new int[N][N];

			for (int i = 0; i < N - 1; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = i + 1; j < N; j++) {
					moveTime[i][j] = Integer.parseInt(st.nextToken());
					moveTime[j][i] = moveTime[i][j];
				}
			}
//			for (int[] m : moveTime) {
//				System.out.println(Arrays.toString(m));
//			}
			placeInfo = new LinkedList<>();
			visited = new boolean[N];
			hotelCnt = 0;
			hotels = new int[N];
			airport = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				String k = st.nextToken();
				if (k.equals("P")) {
					placeInfo.add(new Place(k, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
				} else {
					if (k.equals("A")) {
						airport = i;
					}
					if (k.equals("H")) {
						hotels[hotelCnt] = i;
						hotelCnt++;
					}
					placeInfo.add(new Place(k, 0, 0));
				}
			}

//			int min = Integer.MAX_VALUE;
//			for (int i = 0; i < N; i++) {
//				if(i != airport) {
//					min = Math.min(min, moveTime[airport][i]);
//				}				
//			}
//			System.out.println(min);

			visited[airport] = true;
			Queue<Integer> travels = new LinkedList<>();

			int[] list = new int[N];
			bfs(airport, 0, 0, list, 0, 0, 1);
//			for (int i = 0; i < M-1; i++) {
//				bfs(airport, 0, 0, list, 0, 0);
//			}
//			bfsLast(airport, 0, 0, list, 0);

			System.out.println("#" + testCase + " " + maxResult);
		}
	}

	private static void bfs(int before, int time, int rate, int[] list, int cnt, int hotelTime, int dayCnt) {
		System.out.println("bfs :: " + dayCnt);
		System.out.println(Arrays.toString(list));
		System.out.println(cnt);
		System.out.println(time);
		System.out.println(rate);
		if (dayCnt == M) {
			if (time < 540) {
				time -= moveTime[airport][before];
			} else {
				System.out.println(Arrays.toString(list));
				return;
			}
			for (int i = 0; i < N; i++) {
				if (!visited[i]) {
					visited[i] = true;
					list[cnt] = i + 1;
					bfs(i, time + moveTime[before][i] + placeInfo.get(i).time + moveTime[airport][i],
							rate + placeInfo.get(i).rate, list, cnt + 1, 0, dayCnt);
					list[cnt] = 0;
					;
					visited[i] = false;
				}
			}
		}

		else {
			if (time < 540) {
				time -= hotelTime;
			} else {
				bfs(before, 0, rate, list, cnt, hotelTime, dayCnt + 1);
				System.out.println(Arrays.toString(list));
				return;
			}
			for (int i = 0; i < N; i++) {
				if (!visited[i]) {
					int minHotel = Integer.MAX_VALUE;
					for (int j = 0; j < hotelCnt; j++) {
						minHotel = Math.min(minHotel, moveTime[i][hotels[j]]);
					}
					Queue<Integer> hotelQ = new LinkedList<>();
					for (int j = 0; j < hotelCnt; j++) {
						if (minHotel == moveTime[i][hotels[j]]) {
							hotelQ.add(hotels[j]);
						}
					}
					while (!hotelQ.isEmpty()) {
						int hotelNum = hotelQ.poll();
						visited[i] = true;
						list[cnt] = i + 1;
						bfs(i, time + moveTime[before][i] + placeInfo.get(i).time + moveTime[hotelNum][i],
								rate + placeInfo.get(i).rate, list, cnt + 1, moveTime[hotelNum][i], dayCnt);
						list[cnt] = 0;
						;
						visited[i] = false;
					}

				}
			}
		}

	}

//	private static void bfs(int before, int time, int rate, Queue<Integer> list) {
//	private static void bfs(int before, int time, int rate, int[] list, int cnt, int hotelTime) {
//		System.out.println("bfs :: ");
//		System.out.println(Arrays.toString(list));
//		System.out.println(cnt);
//		System.out.println(time);
//		System.out.println(rate);
//		
//		if(time<540) {
//			time -= hotelTime;
//		}
//		else {
//			System.out.println(Arrays.toString(list));
//			return;
//		}
//		for (int i = 0; i < N; i++) {
//			if (!visited[i]) {
//				int minHotel = Integer.MAX_VALUE;
//				for (int j = 0; j < hotelCnt; j++) {
//					minHotel = Math.min(minHotel, moveTime[i][hotels[j]]);
//				}
//				Queue<Integer> hotelQ = new LinkedList<>();
//				for (int j = 0; j < hotelCnt; j++) {
//					if(minHotel == moveTime[i][hotels[j]]) {
//						hotelQ.add(hotels[j]);
//					}
//				}
//				while(!hotelQ.isEmpty()) {
//					int hotelNum = hotelQ.poll();
//					visited[i] = true;
//					list[cnt] = i+1;
//					bfs(i, time + moveTime[before][i] + placeInfo.get(i).time + moveTime[hotelNum][i]
//							, rate + placeInfo.get(i).rate, list, cnt+1, moveTime[hotelNum][i]);
//					list[cnt] = 0;;
//					visited[i] = false;
//				}
//				
//			}
//		}
//		
//	}

	private static void bfsLast(int before, int time, int rate, int[] list, int cnt) {
		System.out.println("bfs :: ");
		System.out.println(Arrays.toString(list));
		System.out.println(cnt);
		System.out.println(time);
		System.out.println(rate);

		if (time < 540) {
			time -= moveTime[airport][before];
		} else {
			System.out.println(Arrays.toString(list));
			return;
		}
		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				list[cnt] = i + 1;
//				list.offer(i);
//				System.out.println(cnt);
				bfsLast(i, time + moveTime[before][i] + placeInfo.get(i).time + moveTime[airport][i],
						rate + placeInfo.get(i).rate, list, cnt + 1);
				list[cnt] = 0;
				;
				visited[i] = false;
			}
		}

	}

	static class Travel {
		int[] list = new int[N];
		int cnt;
		int sumRate;

		public Travel(int[] list, int cnt, int sumRate) {
			super();
			this.list = list;
			this.cnt = cnt;
			this.sumRate = sumRate;
		}
	}

	static class Place {
		String place;
		int time;
		int rate;

		public Place(String place, int time, int rate) {
			super();
			this.place = place;
			this.time = time;
			this.rate = rate;
		}

		@Override
		public String toString() {
			return "Place [place=" + place + ", time=" + time + ", rate=" + rate + "]";
		}
	}

}
