package programers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_삼각달팽이 {
	public static void main(String[] args) {
		int[] n = { 4, 5, 6, 1000 };

		for (int i = 0; i < n.length; i++) {
			System.out.println(solution(n[i]));
		}
	}

	public static int[] solution(int n) {
		int size = 0;
		if (n % 2 == 0) {
			size = (1 + n) * n / 2;
		} else {
			size = (1 + n) * n / 2 + (n / 2 + 1);
		}

		int[] answer = new int[size];
		int[][] map = new int[n][n];
		
		int height = n;
		int flag = 1;
		while(height != 0) {
			if(flag != 0) {
				for (int i = 0; i < height; i++) {
//					map[]
				}
			}
		}
		
		
		return answer;
	}
}
