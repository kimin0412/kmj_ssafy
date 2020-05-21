package kakao;

import java.util.LinkedList;

class Solution_S2 {
	public static long solution(String expression) {
		long answer = 0;
		boolean[] isUsed = new boolean[3];
		int opCnt = 0;
		String[] arr = expression.split("- | + | *");
		String tmp = "";
		LinkedList<String> q = new LinkedList<String>();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].equals("-") || arr[i].equals("+") || arr[i].equals("*")) {
				if (arr[i].equals("-")) {
					isUsed[0] = true;
				} else if (arr[i].equals("+")) {
					isUsed[1] = true;
				} else if (arr[i].equals("*")) {
					isUsed[2] = true;
				}
				q.add(tmp);
				q.add(arr[i]);
				tmp = "";
			} else {
				tmp += arr[i];
			}
		}
		q.add(tmp);

		for (int i = 0; i < 3; i++) {
			if (isUsed[i] == true)
				opCnt++;
		}


		if (opCnt == 1) {
			answer = Long.parseLong(q.poll());
			while (!q.isEmpty()) {
				String tmpQ = q.poll();
				if (tmpQ.equals("-")) {
					System.out.println(answer);
					answer -= Long.parseLong(q.poll());
				} else if (tmpQ.equals("+")) {
					answer += Long.parseLong(q.poll());
				} else if (tmpQ.equals("*")) {
					answer += Long.parseLong(q.poll());
				}
			}
			answer = Math.abs(answer);
		}

		else if (opCnt == 2) {
			LinkedList<String> tmpQ = new LinkedList<String>();
			int[] order1 = new int[2];
			int[] order2 = new int[2];
			int idx = 0;
			for (int i = 0; i < 3; i++) {
				if (isUsed[i]) {
					order1[idx] = i;
					idx++;
				}
			}
			idx = 0;
			for (int i = 2; i >= 0; i--) {
				if (isUsed[i]) {
					order2[idx] = i;
					idx++;
				}
			}
			long ans1 = 0;
			long ans2 = 0;
			tmpQ = (LinkedList<String>) q.clone();
			for (int i = 0; i < 2; i++) {
				if (order1[i] == 0) {
					while (tmpQ.indexOf("-") != -1) {
						int j = tmpQ.indexOf("-");
						ans1 = Long.parseLong(tmpQ.get(j - 1)) - Long.parseLong(tmpQ.get(j + 1));
						tmpQ.add(j-1, String.valueOf(ans1));
						tmpQ.remove(j);
						tmpQ.remove(j);
						tmpQ.remove(j);
					}
				} else if (order1[i] == 1) {
					while (tmpQ.indexOf("+") != -1) {
						int j = tmpQ.indexOf("+");
						ans1 = Long.parseLong(tmpQ.get(j - 1)) + Long.parseLong(tmpQ.get(j + 1));
						tmpQ.add(j-1, String.valueOf(ans1));
						tmpQ.remove(j);
						tmpQ.remove(j);
						tmpQ.remove(j);
					}
				} else if (order1[i] == 2) {
					while (tmpQ.indexOf("*") != -1) {
						int j = tmpQ.indexOf("*");
						ans1 = Long.parseLong(tmpQ.get(j - 1)) * Long.parseLong(tmpQ.get(j + 1));
						tmpQ.add(j-1, String.valueOf(ans1));
						tmpQ.remove(j);
						tmpQ.remove(j);
						tmpQ.remove(j);
					}
				}

			}
			ans1 = Long.parseLong(tmpQ.poll());

			tmpQ = (LinkedList<String>) q.clone();
			for (int i = 0; i < 2; i++) {
				if (order2[i] == 0) {
					while (tmpQ.indexOf("-") != -1) {
						int j = tmpQ.indexOf("-");
						ans2 = Long.parseLong(q.get(j - 1)) - Long.parseLong(tmpQ.get(j + 1));
						tmpQ.add(j-1, String.valueOf(ans2));
						tmpQ.remove(j);
						tmpQ.remove(j);
						tmpQ.remove(j);
					}
				} else if (order2[i] == 1) {
					while (q.indexOf("+") != -1) {
						int j = q.indexOf("+");
						ans2 = Long.parseLong(tmpQ.get(j - 1)) + Long.parseLong(tmpQ.get(j + 1));
						tmpQ.add(j-1, String.valueOf(ans2));
						tmpQ.remove(j);
						tmpQ.remove(j);
						tmpQ.remove(j);
					}
				} else if (order2[i] == 2) {
					while (tmpQ.indexOf("*") != -1) {
						int j = tmpQ.indexOf("*");
						ans2 = Long.parseLong(tmpQ.get(j - 1)) * Long.parseLong(tmpQ.get(j + 1));
						tmpQ.add(j-1, String.valueOf(ans2));
						tmpQ.remove(j);
						tmpQ.remove(j);
						tmpQ.remove(j);
					}
				}

			}
			ans2 = Long.parseLong(tmpQ.poll());

			answer = Math.max(Math.abs(ans1), Math.abs(ans2));

		} else if (opCnt == 3) {
			int[][] order = { { 0, 1, 2 }, { 0, 2, 1 }, { 1, 0, 2 }, { 1, 2, 0 }, { 2, 0, 1 }, { 2, 1, 0 } };
			for (int i = 0; i < 6; i++) {
				LinkedList<String> tmpQ = new LinkedList<String>();
				long ans1 = 0;
				tmpQ = (LinkedList<String>) q.clone();
				for (int ii = 0; ii < 3; ii++) {
					if (order[i][ii] == 0) {
						while (tmpQ.indexOf("-") != -1) {
							int j = tmpQ.indexOf("-");
							ans1 = Long.parseLong(tmpQ.get(j - 1)) - Long.parseLong(tmpQ.get(j + 1));
							tmpQ.add(j-1, String.valueOf(ans1));
							tmpQ.remove(j);
							tmpQ.remove(j);
							tmpQ.remove(j);
						}
					} else if (order[i][ii] == 1) {
						while (tmpQ.indexOf("+") != -1) {
							int j = tmpQ.indexOf("+");
							ans1 = Long.parseLong(tmpQ.get(j - 1)) + Long.parseLong(tmpQ.get(j + 1));
							tmpQ.add(j-1, String.valueOf(ans1));
							tmpQ.remove(j);
							tmpQ.remove(j);
							tmpQ.remove(j);
						}
					} else if (order[i][ii] == 2) {
						while (tmpQ.indexOf("*") != -1) {
							int j = tmpQ.indexOf("*");
							ans1 = Long.parseLong(tmpQ.get(j - 1)) * Long.parseLong(tmpQ.get(j + 1));
							tmpQ.add(j-1, String.valueOf(ans1));
							tmpQ.remove(j);
							tmpQ.remove(j);
							tmpQ.remove(j);
						}
					}
					ans1 = Long.parseLong(tmpQ.peek());
					answer = Math.max(answer, Math.abs(ans1));
				}
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		String expression0 = "100+200+300+500+20";
		String expression1 = "100-200*300-500+20";
		String expression2 = "50*6-3*2";
		System.out.println(solution(expression0));
		System.out.println(solution(expression1));
		System.out.println(solution(expression2));
	}
}
