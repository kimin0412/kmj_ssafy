package kakao;

import java.util.Arrays;
import java.util.Stack;

class Solution {
	public static int solution(int[][] board, int[] moves) {
		int answer = 0;
		Stack<Integer> stack = new Stack<>();
		for (int[] b : board) {
			System.out.println(Arrays.toString(b));
		}

		top: for (int i = 0; i < moves.length; i++) {
			int pos = moves[i] - 1;
			for (int j = 0; j < board.length; j++) {
				System.out.println(i);
				System.out.println(j);
				System.out.println(pos);
				System.out.println(board[j][pos]);
				System.out.println();
//        		System.out.println(pos);
				if (board[j][pos] != 0) {
					if (stack.isEmpty()) {
						stack.add(board[j][pos]);
						board[j][pos] = 0;
					} else {
						int tmp = stack.peek();
						if (tmp == board[j][pos]) {
							stack.pop();
							board[j][pos] = 0;
							answer += 2;
						} else {
							stack.add(board[j][pos]);
							board[j][pos] = 0;
						}
					}
					continue top;
				}
			}
		}
		for (int[] b : board) {
			System.out.println(Arrays.toString(b));
		}

		return answer;
	}

	public static void main(String[] args) {
		int[][] list = { { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 3 }, { 0, 2, 5, 0, 1 }, { 4, 2, 4, 4, 2 },
				{ 3, 5, 1, 3, 1 } };
		int[] list2 = { 1, 5, 3, 5, 1, 2, 1, 4 };
		System.out.println(solution(list, list2));
	}
}
