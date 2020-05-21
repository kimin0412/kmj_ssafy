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
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_1798_범준이의제주도여행계획_수업 {
	static StringBuilder output = new StringBuilder();
	static int T;
	static int N; // 지점개수 N은 3이상 35이하이다.
	static int M; // 휴가기간 M은 1이상 5이하이다.
	// 각 정점을 연결할 그래프
	static int[][] graph;

	// 관리할 지점들
	static Point airport;
	static List<Point> hotels;
	static List<Point> tourSpots;

	// 최대 만족도
	static int maxSatis;
	static List<Integer> maxSatisPath;

	// 탐색에 사용할 임시 경로
	static Stack<Integer> tempPath;

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("res/swea/d5/1798_범준이의제주도여행계획.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			// 1. 그래프 구성
			graph = new int[N + 1][N + 1];
			// 다음 N-1개 줄에는 지점간의 이동 소요시간 정보가 주어지는데,
			// i번째 줄에는 i번째 지점으로부터 i+1~N번 지점까지의 이동 소요시간이 공백으로 구분되어 주어진다.
			// 해당 경로는 반대로 갈 때도 동일한 이동 소요시간을 갖는다.

			for (int i = 1; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = i + 1; j < graph.length; j++) {
					graph[i][j] = graph[j][i] = Integer.parseInt(st.nextToken());
				}
			}

			// 2. 지점 정보 가져오기
			tourSpots = new ArrayList<>();
			hotels = new ArrayList<>();

			for (int n = 1; n <= N; n++) {
				st = new StringTokenizer(br.readLine(), " ");
				String type = st.nextToken();
				if (type.equals("H")) {
					hotels.add(new Point(type, n));
				} else if (type.equals("A")) {
					airport = new Point(type, n);
				} else {
					int playTime = Integer.parseInt(st.nextToken());
					int satis = Integer.parseInt(st.nextToken());
					tourSpots.add(new Point(type, n, playTime, satis));
				}
			}

			// 3. 관광지에 가장 가까운 호텔 정보 설정해주기. - graph
			for (Point p : tourSpots) {
				int min = Integer.MAX_VALUE;
				for (Point h : hotels) {
					if (graph[p.idx][h.idx] < min) {
						min = graph[p.idx][h.idx];
						p.nearH = h;
					}
				}
			}

			// 4. 여행 준비
			maxSatis = Integer.MIN_VALUE;
			tempPath = new Stack<>();

			// solve()
			solve(0, airport, 0, 0, new boolean[N + 1]);

			// 5. 결과 출력
			output.append("#").append(tc).append(" ");
			if (maxSatis == Integer.MIN_VALUE) {
				output.append(0);
			} else {
				output.append(maxSatis).append(" ");
				for (int i : maxSatisPath) {
					output.append(i).append(" ");
				}
			}
			output.append("\n");
		}
		System.out.println(output);
	}

	private static void solve(int day, Point start, int satis, int time, boolean[] visited) {
		// 종료 조건?
		if(day == M) {
			if(satis > maxSatis) {
				maxSatis = satis;
				// 최대 만족도에서의 경로 전달
				maxSatisPath = new ArrayList<>(tempPath);
			}
			return;
		}
		
		// 일반 탐색.
		boolean canGoNext = false;
		
		for (Point point : tourSpots) {
			// 갈 수 있는 지점들을 찾아서 계속 돌아다닌다.
			if(!visited[point.idx]) {
				// 미방문 이라면.. 그 지점을 갈 수 있는지 시간을 계산해볼 필요가 있다.
				int tempTime = time + graph[start.idx][point.idx] + point.playTime;
				if(day == M-1) { // 마지막 날이라면
					tempTime += graph[point.idx][airport.idx];
				}else {
					tempTime += graph[point.idx][point.nearH.idx];
				}
				
				if(tempTime> 540) {
					continue;
				}
				
				canGoNext = true;
				visited[point.idx] = true;
				tempPath.push(point.idx);
				solve(day, point, satis + point.satis, time + graph[start.idx][point.idx] + point.playTime, visited);
				tempPath.pop();
				visited[point.idx] = false;
			}
		}
		
		// 관광지로 못가면 날짜에 따라서 공항/호텔로 이동
		if(!canGoNext) {
			if(day == M-1) { // 마지막 날이라면
				tempPath.push(airport.idx);
				solve(day+1, airport, satis, 0, visited);
				tempPath.pop();
			}else {
				for (Point hotel : hotels) {
					if(time + graph[start.idx][hotel.idx] <= 540) {
						tempPath.push(hotel.idx);
						solve(day+1, hotel, satis, 0, visited);
						tempPath.pop();
					}
				}
			}
		}
	}

	static class Point {
		String type; // A, H, P
		int idx;
		int playTime;
		int satis;
		Point nearH;

		public Point(String type, int idx, int playTime, int satis) {
			super();
			this.type = type;
			this.idx = idx;
			this.playTime = playTime;
			this.satis = satis;
		}

		public Point(String type, int idx) {
			super();
			this.type = type;
			this.idx = idx;
		}

		@Override
		public String toString() {
			return "Point [type=" + type + ", idx=" + idx + ", playTime=" + playTime + ", satis=" + satis + "]";
		}
	}
}
