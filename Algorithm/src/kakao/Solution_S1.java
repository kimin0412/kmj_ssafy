package kakao;

class Solution_S1 {
	public static String solution(int[] numbers, String hand) {
		String answer = "";
		int Lr = 4, Lc = 1;
		int Rr = 4, Rc = 3;
		for (int i = 0; i < numbers.length; i++) {
			int Ldis = 0;
			int Rdis = 0;
			switch (numbers[i]) {
			case 1:
				Lr = 1;
				Lc = 1;
				answer += "L";
				break;
			case 4:
				Lr = 2;
				Lc = 1;
				answer += "L";
				break;
			case 7:
				Lr = 3;
				Lc = 1;
				answer += "L";
				break;
			case 3:
				Rr = 1;
				Rc = 3;
				answer += "R";
				break;
			case 6:
				Rr = 2;
				Rc = 3;
				answer += "R";
				break;
			case 9:
				Rr = 3;
				Rc = 3;
				answer += "R";
				break;
			case 2:
				Ldis = Math.abs(Lr - 1) + Math.abs(Lc - 2);
				Rdis = Math.abs(Rr - 1) + Math.abs(Rc - 2);
				if (Ldis < Rdis) {
					Lr = 1;
					Lc = 2;
					answer += "L";
				} else if (Ldis == Rdis) {
					if (hand.equals("left")) {
						Lr = 1;
						Lc = 2;
						answer += "L";
					} else {
						Rr = 1;
						Rc = 2;
						answer += "R";
					}
				} else {
					Rr = 1;
					Rc = 2;
					answer += "R";
				}
				break;
			case 5:
				Ldis = Math.abs(Lr - 2) + Math.abs(Lc - 2);
				Rdis = Math.abs(Rr - 2) + Math.abs(Rc - 2);
				if (Ldis < Rdis) {
					Lr = 2;
					Lc = 2;
					answer += "L";
				} else if (Ldis == Rdis) {
					if (hand.equals("left")) {
						Lr = 2;
						Lc = 2;
						answer += "L";
					} else {
						Rr = 2;
						Rc = 2;
						answer += "R";
					}
				} else {
					Rr = 2;
					Rc = 2;
					answer += "R";
				}
				break;
			case 8:
				Ldis = Math.abs(Lr - 3) + Math.abs(Lc - 2);
				Rdis = Math.abs(Rr - 3) + Math.abs(Rc - 2);
				if (Ldis < Rdis) {
					Lr = 3;
					Lc = 2;
					answer += "L";
				} else if (Ldis == Rdis) {
					if (hand.equals("left")) {
						Lr = 3;
						Lc = 2;
						answer += "L";
					} else {
						Rr = 3;
						Rc = 2;
						answer += "R";
					}
				} else {
					Rr = 3;
					Rc = 2;
					answer += "R";
				}
				break;
			case 0:
				Ldis = Math.abs(Lr - 4) + Math.abs(Lc - 2);
				Rdis = Math.abs(Rr - 4) + Math.abs(Rc - 2);
				if (Ldis < Rdis) {
					Lr = 4;
					Lc = 2;
					answer += "L";
				} else if (Ldis == Rdis) {
					if (hand.equals("left")) {
						Lr = 4;
						Lc = 2;
						answer += "L";
					} else {
						Rr = 4;
						Rc = 2;
						answer += "R";
					}
				} else {
					Rr = 4;
					Rc = 2;
					answer += "R";
				}
				break;

			}
		}

		return answer;
	}

	public static void main(String[] args) {
		int[] numbers1 = { 1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5 };
		String hand1 = "right";
		int[] numbers2 = { 7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2 };
		String hand2 = "left";
		int[] numbers3 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 };
		String hand3 = "right";
		System.out.println(solution(numbers1, hand1));
		System.out.println(solution(numbers2, hand2));
		System.out.println(solution(numbers3, hand3));
	}
}
