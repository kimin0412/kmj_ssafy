package kakao_spring_intern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution1 {
	public static void main(String[] args) throws Exception, IOException {
//		int row1 = 3;
//		int col1 = 3;
//		int initR1 = 0;
//		int initC1 = 0;
//		int finalR1 = 1;
//		int finalC1 = 2;
//		List<Integer> costRow1 = new ArrayList<Integer>();
//		List<Integer> costCol1 = new ArrayList<Integer>();
//		costRow1.add(2);
//		costRow1.add(5);
//		costCol1.add(6);
//		costCol1.add(1);
//
//		int row2 = 4;
//		int col2 = 4;
//		int initR2 = 1;
//		int initC2 = 2;
//		int finalR2 = 3;
//		int finalC2 = 3;
//		List<Integer> costRow2 = new ArrayList<Integer>();
//		List<Integer> costCol2 = new ArrayList<Integer>();
//		costRow2.add(1);
//		costRow2.add(2);
//		costRow2.add(3);
//		costCol2.add(7);
//		costCol2.add(8);
//		costCol2.add(9);

//		System.out.println(minCost(row1, col1, initR1, initC1, finalR1, finalC1, costRow1, costCol1));
//		System.out.println(minCost(row2, col2, initR2, initC2, finalR2, finalC2, costRow2, costCol2));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int row1 = Integer.parseInt(br.readLine());
		int col1 = Integer.parseInt(br.readLine());
		int initR1 = Integer.parseInt(br.readLine());
		int initC1 = Integer.parseInt(br.readLine());
		int finalR1 = Integer.parseInt(br.readLine());
		int finalC1 = Integer.parseInt(br.readLine());
		List<Integer> costRow1 = new ArrayList<Integer>();
		List<Integer> costCol1 = new ArrayList<Integer>();

		int cntR = Integer.parseInt(br.readLine());
		for (int i = 0; i < cntR; i++) {
			costRow1.add(Integer.parseInt(br.readLine()));
		}

		int cntC = Integer.parseInt(br.readLine());
		for (int i = 0; i < cntC; i++) {
			costCol1.add(Integer.parseInt(br.readLine()));
		}

		System.out.println(minCost(row1, col1, initR1, initC1, finalR1, finalC1, costRow1, costCol1));

	}

	private static int minCost(int rows, int cols, int initR, int initC, int finalR, int finalC, List<Integer> costRows,
			List<Integer> costCols) {
		int ans = Integer.MAX_VALUE;
		int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
		boolean visit[][] = new boolean[rows][cols];
		LinkedList<int[]> queue = new LinkedList<int[]>();
		visit[initR][initC] = true;
		queue.add(new int[] { initR, initC, 0 });

		while (!queue.isEmpty()) {
			int[] q = queue.poll();

			if (q[0] == finalR && q[1] == finalC) {
				System.out.println("최소 : " + ans);
				ans = Math.min(ans, q[2]);
//				break;
			}

			for (int d = 0; d < 4; d++) {
				int nr = q[0] + dir[d][0];
				int nc = q[1] + dir[d][1];
				if ((nr < rows && nr > -1 && nc < cols && nc > -1) && !visit[nr][nc]) {
					visit[nr][nc] = true;
					int cost = q[2];
					if (d == 0 || d == 1) {
//					if (d == 1) {
//						System.out.println("nr, nc, cost, costRows.get(q[0]) : " + nr + ", " + nc + ", " + q[2] + ", " + costRows.get(q[0]));
						cost += costRows.get(q[0]);
//						queue.add(new int[] { nr, nc, q[2] + costRows.get(q[0]) });
					} else {
//					} else if (d == 3) {
						cost += costCols.get(q[1]);
//						System.out.println("nr, nc, cost, costCols.get(q[1]) : " + nr + ", " + nc + ", " + q[2]+ ", " + costCols.get(q[1]));
					}
					System.out.println("nr, nc, cost : " + nr + ", " + nc + ", " + cost);
					queue.add(new int[] { nr, nc, cost });
				}
			}
		}

		return ans;
	}

}
