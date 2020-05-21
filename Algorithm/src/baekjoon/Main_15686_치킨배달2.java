package baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

import com.ssafy.combination.CombinationTest1;

import baekjoon.Main_3055_탈출.Point;

public class Main_15686_치킨배달2 {

	static List<Point> chickenStroes, homes;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/baekjoon/15686_치킨배달.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			// 집과 치킨집 가져오기.
			chickenStroes = new ArrayList<>();
			homes = new ArrayList<>();
			
			for (int r = 1; r <= N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 1; c <= N; c++) {
					int info = Integer.parseInt(st.nextToken());
					if(info == 1) {
//						homes.add(e)
					}
				}
			}
			
			// 전체 치킨집 chickenStores.size()에서 M개 고르기.
//			Comb(M, new Point[m], 0);
			

			System.out.println("#" + tc + " ");
		}
	}
	
	

	/**
	 * 
	 * @param ti : 찾을 개수
	 * @param temp : 찾은 녀석들 
	 * @param si : 찾는 시작 위치 
	 */
	private static void Comb(int ti, Point[] temp, int si) {
		
	}



	private static int distance(int[] th, int[] ch) {
		return Math.abs(th[0] - ch[0]) + Math.abs(th[1] - ch[1]);
	}
}
