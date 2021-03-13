package programers;

import java.util.ArrayList;
import java.util.List;

public class Solution_크레인인형뽑기게임 {
	public static void main(String[] args) {
		int[][] board = { { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 3 }, { 0, 2, 5, 0, 1 }, { 4, 2, 4, 4, 2 },
				{ 3, 5, 1, 3, 1 } };
		int[] moves = { 1, 5, 3, 5, 1, 2, 1, 4 };
		System.out.println(solution(board, moves));
	}

	public static int solution(int[][] board, int[] moves) {
		int answer = 0;
		List<Integer> arr = new ArrayList<Integer>();
		int idx = -1;

		for (int i = 0; i < moves.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[j][moves[i] - 1] == 0)
					continue;
				else {
					arr.add(board[j][moves[i] - 1]);
					board[j][moves[i] - 1] = 0;
					idx++;
					if (idx != 0) {
						if (arr.get(idx) == arr.get(idx - 1)) {
							arr.remove(idx);
							arr.remove(idx - 1);
							idx -= 2;
							answer++;
						}
					}
					break;
				}
			}
		}

		return answer * 2;
	}
}
